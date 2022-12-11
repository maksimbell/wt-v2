package com.example.lab4.controller.command;

import com.example.lab4.controller.command.admin.AddRoomCommand;
import com.example.lab4.controller.command.admin.MakeRoomCommand;
import com.example.lab4.controller.command.admin.ShowRoomsCommand;
import com.example.lab4.controller.command.common.*;
import com.example.lab4.controller.command.user.MainPageCommand;
import com.example.lab4.controller.command.user.OrderCommand;

public class CommandFactory {
    private static final CommandFactory INSTANCE = new CommandFactory();
    private static final String MAIN_PAGE = "mainPage";
    private static final String MAKE_ORDER = "makeOrder";
    private static final String LOGIN = "login";
    private static final String SHOW_ROOMS = "showRooms";
    private static final String CHANGE_LANGUAGE = "changeLanguage";
    private static final String ADD_ROOM = "addRoom";
    private static final String DEOCCUPY_ROOM = "deoccupyRoom";
    private static final String LOG_OUT = "signOut";
    private static final String SIGN_UP = "signUp";
    private static final String START_PAGE = "startPage";
    private static final String START_LOGIN = "startLogin";

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    public Command getCommand(String command) {
        switch (command) {
            case LOGIN:
                return new LoginCommand();
            case SHOW_ROOMS:
                return new ShowRoomsCommand();
            case MAIN_PAGE:
                return new MainPageCommand();
            case CHANGE_LANGUAGE:
                return new ChangeLanguageCommand();
            case ADD_ROOM:
                return new AddRoomCommand();
            case MAKE_ORDER:
                return new OrderCommand();
            case DEOCCUPY_ROOM:
                return new MakeRoomCommand();
            case LOG_OUT:
                return new LogoutCommand();
            case START_PAGE:
                return new StartPageCommand();
            case SIGN_UP:
                return new SignupCommand();
            case START_LOGIN:
                return new StartLoginCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}

