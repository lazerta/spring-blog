package com.shawn.springblog.config;

import com.shawn.springblog.util.Const;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(Const.CURRENT_USER) != null) {
            return true;
        }
        response.sendRedirect("/admin");
        return false;
    }
}
