package com.ssm.tokenhelper.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangxing
 * @Date: 2019/4/26 0:29
 */
public class AuthFilter implements Filter {

    private String sessionKey;

    private String redirectUrl;

    private String unCheckUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.sessionKey = filterConfig.getInitParameter("sessionKey");
        this.redirectUrl = filterConfig.getInitParameter("redirectUrl");
        this.unCheckUrls = filterConfig.getInitParameter("unCheckUrls");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String reqUrl = request.getServletPath();

        if (reqUrl.endsWith("/logout")){
            // 移除该值
            // request.getSession().removeAttribute(sessionKey);
            // 销毁该session
            request.getSession().invalidate();
            response.getWriter().write("/login.html");
            return;
        }

        // 不校验的url，直接放行
        List<String> urls = Arrays.asList(unCheckUrls.split(","));
        if (null != urls && urls.contains(reqUrl)) {
            System.out.println("unCheckUrl:" + reqUrl);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 送session中获取token,为null则未登录，跳转至登录界面
        Object token = request.getSession().getAttribute(sessionKey);
        if (null == token) {
            System.out.println("withoutTokenURl:" + reqUrl);
//            response.sendRedirect(request.getContextPath() + redirectUrl);
            response.getWriter().write("/login.html");
            return;
        }

        // 已登录，则放行
        System.out.println("withoutURl:" + reqUrl);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
