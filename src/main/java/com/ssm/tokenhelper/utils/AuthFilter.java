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

        String url = request.getServletPath();
        if (url.endsWith("logout")){
            request.getSession().removeAttribute(sessionKey);
            response.sendRedirect(request.getContextPath() + redirectUrl);
            return;
        }
        List<String> unCheckUrlList = Arrays.asList(unCheckUrls.split(","));
        if (null != unCheckUrlList && unCheckUrlList.contains(url)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Object token = request.getSession().getAttribute(sessionKey);
        if (null == token) {
            response.sendRedirect(request.getContextPath() + redirectUrl);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
