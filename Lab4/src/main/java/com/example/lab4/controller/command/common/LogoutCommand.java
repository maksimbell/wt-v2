package com.example.lab4.controller.command.common;

import com.example.lab4.controller.command.Command;
import com.example.lab4.controller.command.CommandResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String ROLE = "role";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(ID);
        session.removeAttribute(USERNAME);
        session.removeAttribute(ROLE);
        return CommandResult.forward(LOGIN_PAGE);
    }
}

