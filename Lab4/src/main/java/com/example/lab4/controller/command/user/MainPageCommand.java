package com.example.lab4.controller.command.user;

import java.util.List;
import com.example.lab4.controller.command.Command;
import com.example.lab4.controller.command.CommandResult;
import com.example.lab4.entity.impl.Room;
import com.example.lab4.exception.ServiceException;
import com.example.lab4.service.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> freeRoomList = roomService.findFree();
        request.setAttribute(ROOM_LIST, freeRoomList);
        return CommandResult.forward(MAIN_PAGE);
    }
}

