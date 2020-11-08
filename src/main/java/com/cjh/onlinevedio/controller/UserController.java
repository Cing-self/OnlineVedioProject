package com.cjh.onlinevedio.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.cjh.onlinevedio.domain.User;
import com.cjh.onlinevedio.dto.ResponseResult;
import com.cjh.onlinevedio.exception.UserException;
import com.cjh.onlinevedio.service.UserService;
import com.cjh.onlinevedio.util.Constants;
import com.cjh.onlinevedio.dto.LoginToken;
import com.cjh.onlinevedio.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 退出登录，清空用户的信息
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        System.out.println("LoginOut：");
        //1、清空用户session
        session.removeAttribute(Constants.LOGIN_USER);
        //2、清空application的Token
        String tokenValue = Util.getCookieTokenValue(request);
        if (!StrUtil.isEmpty(tokenValue)){
            ServletContext application = session.getServletContext();
            HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);
            if (!ObjectUtil.isNull(tokenMap)){
                tokenMap.remove(tokenValue);
            }
        }
        //3、设置cookie失效
        Cookie cookie = new Cookie("autoToken", "invalid");
        cookie.setMaxAge(1);
        cookie.setPath("/");
        response.addCookie(cookie);
        //重定向到首页
        return "redirect: /";
    }

    /**
     * 登录功能
     * @param user  用户信息
     * @param autoLogin 是否为自动登录
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, String autoLogin, HttpServletRequest request, HttpServletResponse response){
        System.out.println(autoLogin);
        //1、验证用户信息的合法性
        if (StrUtil.isEmpty(user.getUEmail()) || StrUtil.isEmpty(user.getUPassword())){
            throw new UserException("参数错误");
        }
        //2、获取application全局对象和seesion对象
        HttpSession session = request.getSession();
        ServletContext application = session.getServletContext();
        //3、根据用户的账号和密码查询数据库中的用户
        //   如果存在，则保存到session作用域里
        User dbUser = userService.login(user);
        if (dbUser != null){
            //将用户保存到session作用域里
            session.setAttribute(Constants.LOGIN_USER, dbUser);
        }

        //4、判断是否需要自动登录
        if (!StrUtil.isEmpty(autoLogin) || "1".equals(autoLogin)){
            //1）生成用户的LoginToken对象
            LoginToken loginToken = Util.generateLoginToken(request, dbUser);
            //2）生成cookie返回给客户端凭证cookie
            Cookie cookie = new Cookie("autoToken", loginToken.generateToken());
            //设置COOKIE
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 48);
            //3）服务器端保存token对应loginToken数据
            response.addCookie(cookie);

            //4）服务器保存对应的LoginToken用户登录数据：autoToken-LoginToken对象
            HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);
            if (tokenMap == null){
                //不存在，初始化
                tokenMap = new HashMap<>();
                tokenMap.put(loginToken.generateToken(), loginToken);
                application.setAttribute(Constants.AUTO_LOGIN_TOKEN, tokenMap);
            }else {
                //已经存在了，直接保存
                tokenMap.put(loginToken.generateToken(), loginToken);
            }
        }
        //重定向到首页
        return "redirect: /";
    }

    /**
     * 登录信息检测--ajax
     * @param user  用户信息
     * @return  检测结果
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult checkLogin(User user){
        ResponseResult result = new ResponseResult(-1, "login error");
        if (StrUtil.isEmpty(user.getUEmail()) || StrUtil.isEmpty(user.getUPassword())){
            return result;
        }
        User dbUser = userService.login(user);
        if (dbUser != null && dbUser.getuFlag() == 1){
            result.setRcode(1);
            result.setMessage("login success");
        }
        if (dbUser.getuFlag() != 1){
            result.setMessage("The user has not been registered");
        }

        return result;
    }

    /**
     * 注册功能
     * @param user 注册的用户信息
     * @param session 用户的session
     * @param vcode 用户的验证码
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(User user, HttpSession session, String vcode){

        String session_vcode = (String)session.getAttribute("session_vcode");
        if (StrUtil.isEmpty(vcode)){
            //TODO 跳转到错误页面
            throw new UserException("验证码错误");
        }

        boolean emailMatch = ReUtil.isMatch("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", user.getUEmail());
        boolean phoneMatch = ReUtil.isMatch("1[3456789]\\d{9}$", user.getUPhone());
        boolean passwordMatch = ReUtil.isMatch("^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$", user.getUPassword());
        if (!emailMatch || !phoneMatch || !passwordMatch){
            //TODO 跳转到错误页面
            throw new UserException("注册信息有误");
        }

        //参数验证通过
        int code = userService.regist(user);
        if (code != 1){
            //TODO 数据库插入数据失败，跳转到错误页面
            throw new UserException("注册失败");
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("uName", user.getUName());
        map.put("uEmail", user.getUEmail());
        User newUser = userService.selectUser(map);

        //注册成功直接登录
        session.setAttribute("login_user", newUser);

        return "redirect: /";
    }

    /**
     * 验证邮箱是否存在
     * @param email 邮箱
     * @return 返回Json数据格式
     */
    @RequestMapping("/checkEmail")
    @ResponseBody
    public ResponseResult checkEmail(String email){
        User user = userService.existEmail(email);
        ResponseResult result = new ResponseResult(-1, "email exist");

        if (user == null){
            result.setRcode(1);
            result.setMessage("ok");
            return result;
        }

        return result;
    }
}
