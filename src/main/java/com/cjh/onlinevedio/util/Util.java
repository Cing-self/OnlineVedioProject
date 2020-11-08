package com.cjh.onlinevedio.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.cjh.onlinevedio.domain.User;
import com.cjh.onlinevedio.dto.LoginToken;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class Util {


    /**
     * 生成服务器保存的用户Token对象
     * @param request
     * @param user
     * @return
     */
    public static LoginToken generateLoginToken(HttpServletRequest request, User user){
        String userAgent = request.getHeader("User-Agent");
        LoginToken loginToken = new LoginToken();
        loginToken.setIp(getIPAddress(request));
        loginToken.setNow(DateUtil.now());
        loginToken.setUser(user);
        loginToken.setUserAgent(userAgent);

        return loginToken;
    }

    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getCookieTokenValue(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (ObjectUtil.isAllEmpty(cookies) || cookies.length <= 0){
            //cookie没有数据
            return "";
        }
        String cookieToken = null;
        for (Cookie cookie : cookies){
            String cName = cookie.getName();
            if ("autoToken".equals(cName)){
                return cookie.getName();
            }
        }

        return "";
    }
    /**
     * 根据Token获取Application中的用户信息
     * @param cookies   获取cookies中token码
     * @param application   获取所有用户信息，根据token码获取指定用户信息
     * @return
     */
    public static User getUserByApplication(Cookie[] cookies, ServletContext application){
        String cookieToken = null;
        for (Cookie cookie : cookies){
            String cName = cookie.getName();
            if ("autoToken".equals(cName)){
                cookieToken = cookie.getValue();
            }
        }
        System.out.println("cookieToken：" + cookieToken);
        HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);
        LoginToken loginToken = tokenMap.get(cookieToken);

        return loginToken.getUser();
    }

    /**
     * Token的校验
     * @param cookies
     * @param application
     * @return
     */
    public static boolean checkLoginToken(Cookie[] cookies, ServletContext application){
        //1、判断cookie是否存在
        if (ObjectUtil.isEmpty(cookies) || cookies.length <= 0){
            //cookie没有数据
            return false;
        }
        //2、判断cookie的autoToken是否存在
        String cookieToken = null;
        for (Cookie cookie : cookies){
            String cName = cookie.getName();
            if ("autoToken".equals(cName)){
                cookieToken = cookie.getValue();
            }
        }
        if (StrUtil.isEmpty(cookieToken)){
            //需要重新登录
            return false;
        }

        //3、判断application全局作用域是否存在用户的autoToken及对应的用户信息
        HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);
        //3.1 判断用户信息是否存在
        if (ObjectUtil.isEmpty(tokenMap)){
            //服务器中保存token的数据还未初始化
            return false;
        }
        //3.2 判断cookieToken是否存在对应的用户数据
        LoginToken loginToken = tokenMap.get(cookieToken);
        if (ObjectUtil.isNull(loginToken)){
            //服务器中没有对应的用户数据
            return false;
        }

        //3.3 从loginToken中获取用户的token字符串
        String serverToken = loginToken.generateToken();

        //3.4 判断用户的token是否超时（48时内）
        String tokenLastTime = loginToken.getNow();
        DateTime tokenLastDateTime = DateUtil.parse(tokenLastTime);
        if (System.currentTimeMillis() - tokenLastDateTime.getTime() >= (48 * 60 * 60 * 1000)){
            return false;
        }

        //3.5 判断cookie的token和application的token是否一致
        if (cookieToken.equals(serverToken)){
            //验证通过，可以自动登录
            return true;
        }else {
            //客户端token凭证失效，需要重新登录
            return false;
        }
    }
}
