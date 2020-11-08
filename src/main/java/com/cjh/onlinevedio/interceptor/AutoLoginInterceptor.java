package com.cjh.onlinevedio.interceptor;

import com.cjh.onlinevedio.domain.User;
import com.cjh.onlinevedio.util.Constants;
import com.cjh.onlinevedio.util.Util;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 判断是否可以自动登录
 */
public class AutoLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        ServletContext application = session.getServletContext();
        boolean valid = Util.checkLoginToken(cookies, application);
        if (valid){
            User user = Util.getUserByApplication(cookies, application);
            session.setAttribute(Constants.LOGIN_USER, user);
        }
        return true;
    }
}
