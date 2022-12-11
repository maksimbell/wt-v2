package com.example.lab4.controller.command.admin;

import com.example.lab4.controller.command.Command;
import com.example.lab4.controller.command.CommandResult;
import com.example.lab4.controller.command.Validation;
import com.example.lab4.entity.impl.Room;
import com.example.lab4.exception.ServiceException;
import com.example.lab4.service.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowRoomsCommand implements Command {
    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_LIST = "roomList";
    private static final String MESSAGE = "message";
    private static final String NOTIFY_MESSAGE = "notifyMessage";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> fullRoomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, fullRoomList);

        String notifyMessage = request.getParameter(MESSAGE);
        if (notifyMessage != null) {
            request.setAttribute(NOTIFY_MESSAGE, notifyMessage);
        }

        return CommandResult.forward(ROOMS_PAGE);
    }
}
