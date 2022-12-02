package com.wt.server;

import com.wt.dao.impl.CaseDAOImpl;
import com.wt.entity.User;
import com.wt.repository.impl.CaseRepositoryImpl;
import com.wt.service.CaseService;
import com.wt.service.impl.CaseServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class UserHandler implements Runnable {

    private Socket socket;
    private User user;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private CaseService caseService;

    public UserHandler(User user) {
        this.user = user;
    }

    public UserHandler() {
    }

    public UserHandler(Socket socket, User user) {
        try {
            this.socket = socket;
            this.user = user;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.caseService = new CaseServiceImpl(
                    new CaseRepositoryImpl(new CaseDAOImpl()));
        } catch (IOException e) {
            closeEverything(socket, dataInputStream, dataOutputStream);
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public UserHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                String initMessage = """
                    1. Show all cases
                    2. Create case
                    3. Change case
                    """;

                sendMessage(initMessage);

                var msg = getMessageFromClient();

                switch (msg) {
                    case "1" -> showAllcases();
                }
            } catch (IOException e) {
                closeEverything(socket, dataInputStream, dataOutputStream);
                break;
            }
        }
    }

    private void showAllcases() throws IOException {
        sendMessage(caseService.findAll().toString());
    }

    private String getMessageFromClient() throws IOException {
        int messageLength = dataInputStream.readInt();
        return new String(dataInputStream.readNBytes(messageLength), StandardCharsets.UTF_8);

    }

    private void sendMessage(String msg) throws IOException {
        dataOutputStream.writeInt(msg.getBytes(StandardCharsets.UTF_8).length);
        dataOutputStream.write(msg.getBytes(StandardCharsets.UTF_8));
        dataOutputStream.flush();
    }

    private void closeEverything(Socket socket,
                                 DataInputStream dataInputStream,
                                 DataOutputStream dataOutputStream) {
        try {
            if (socket != null) {
                socket.close();
            }
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
