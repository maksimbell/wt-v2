package com.example.lab4.filter;

import com.example.lab4.entity.impl.Role;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AccessFilter implements Filter {

    private static final String SHOW_ROOMS = "showRooms";
    private static final String MAIN_PAGE = "mainPage";
    private static final String MAKE_ORDER = "makeOrder";
    private static final String ADD_ROOM = "addRoom";
    private static final String DEOCCUPY_ROOM = "deoccupyRoom";
    private static final String ROLE = "role";
    private static final String COMMAND = "command";
    private static final Integer ERROR_NUMBER = 403;

    public void init(FilterConfig filterConfig) {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String parameter = servletRequest.getParameter(COMMAND);
        if (parameter != null) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            Role role = (Role) session.getAttribute(ROLE);
            if (parameter.equals(SHOW_ROOMS) || parameter.equals(ADD_ROOM) || parameter.equals(DEOCCUPY_ROOM)) {
                if (role.equals(Role.USER)) {
                    ((HttpServletResponse) servletResponse).sendError(ERROR_NUMBER);
                    return;
                }
            } else if (parameter.equals(MAIN_PAGE) || parameter.equals(MAKE_ORDER)) {
                if (role.equals(Role.ADMIN)) {
                    ((HttpServletResponse) servletResponse).sendError(ERROR_NUMBER);
                    return;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
