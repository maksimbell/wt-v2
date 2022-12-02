package com.wt.server;

import com.wt.entity.Role;
import com.wt.entity.User;
import com.wt.server.AdminHandler;
import com.wt.server.UserHandler;
import java.net.Socket;

public class HandlerFactory {

    public Runnable getHandler(User user, Socket socket) {
        return switch (user.getRole()) {
            case USER -> new UserHandler(socket, user);
            case ADMIN -> new AdminHandler(socket, user);
        };
    }
}
