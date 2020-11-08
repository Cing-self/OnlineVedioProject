package com.cjh.onlinevedio.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对异常的处理
 */
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        if (e instanceof UserException){
            mv.addObject("data", e.getMessage());
        }else {
            mv.addObject("data", "其他信息");
        }

        return mv;
    }
}
