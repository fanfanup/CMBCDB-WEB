package com.cmbc.liquibase.adapter;


import com.cmbc.liquibase.Utils.ConverterSystem;
import com.cmbc.liquibase.Utils.ReponseCode;
import com.cmbc.liquibase.controller.response.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author ff 2018-12-20
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    /**
     * 检查是否登录
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if(request.getRequestURI().equals("/error")){
            BaseResponse br = new BaseResponse();
            br.setCode(ReponseCode.ILLEGAL_REQUEST);
            response.getWriter().write(new ObjectMapper().writeValueAsString(br));
            return false;
        }

        HttpSession session = request.getSession();
        if (session.getAttribute(ConverterSystem.SESSION_USER_KEY )!= null)
            return true;

        // 跳转登录
        if(request.getRequestURI().endsWith(".html")){
            String url = "/login.html";
            response.sendRedirect(url);
        }else {
            if(request.getRequestURI().startsWith("/salary/intoUpdate") || request.getRequestURI().startsWith("/salary/intoShow")){
                String url = "/login.html";
                response.sendRedirect(url);
            }else {
                BaseResponse br = new BaseResponse();
                br.setCode(ReponseCode.NOT_LOGINED);
                response.getWriter().write(new ObjectMapper().writeValueAsString(br));
            }
        }

        return false;
    }

}