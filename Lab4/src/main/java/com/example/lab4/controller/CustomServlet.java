package com.example.lab4.controller;

import java.io.*;

import com.example.lab4.controller.command.Command;
import com.example.lab4.controller.command.CommandFactory;
import com.example.lab4.controller.command.CommandResult;
import com.example.lab4.exception.ServiceException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "customServlet", value = "/custom-servlet")
public class CustomServlet extends HttpServlet {
    private String message;

    private static final String COMMAND = "command";

    private static final String ERROR_PAGE = "/WEB-INF/pages/error/Error500.jsp";

    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter(COMMAND);
        Command command = CommandFactory.getInstance().getCommand(parameter);

        try {
            CommandResult commandResult = command.execute(req, resp);
            String page = commandResult.getPage();
            if (commandResult.isRedirect()) {
                resp.sendRedirect(page);
            } else {
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
                requestDispatcher.forward(req, resp);
            }
        } catch (ServiceException e) {
            CommandResult.forward(ERROR_PAGE);
        }
    }

    public void destroy() {
    }
}