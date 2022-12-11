package com.example.lab4.filter;

import com.example.lab4.entity.impl.Role;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LangFilter implements Filter {

    private static final String EN = "EN";
    private static final String LANGUAGE = "language";

    public void init(FilterConfig filterConfig) {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String language = (String) session.getAttribute(LANGUAGE);
        if (language == null) {
            language = EN;
            session.setAttribute(LANGUAGE, language);
        }

        session.setAttribute(LANGUAGE, language);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
