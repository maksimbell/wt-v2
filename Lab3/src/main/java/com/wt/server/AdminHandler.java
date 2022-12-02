package com.wt.server;

import com.wt.dao.impl.CaseDAOImpl;
import com.wt.entity.Case;
import com.wt.entity.User;
import com.wt.repository.impl.CaseRepositoryImpl;
import com.wt.service.CaseService;
import com.wt.service.impl.CaseServiceImpl;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AdminHandler implements Runnable {

    private Socket socket;
    private User user;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private CaseService caseService;

    public AdminHandler(Socket socket, User user) {
        try {
            this.socket = socket;
            this.user = user;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.caseService = new CaseServiceImpl(new CaseRepositoryImpl(new CaseDAOImpl()));
        } catch (IOException e) {
            closeEverything(socket, dataInputStream, dataOutputStream);
        }
    }

    public AdminHandler(User user) {
        this.user = user;
    }

    public AdminHandler() {
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AdminHandler(Socket socket) {
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
                    case "1" -> showAllCases();
                    case "2" -> createCase();
                    case "3" -> changeCase();
                }
            } catch (IOException e) {
                closeEverything(socket, dataInputStream, dataOutputStream);
                break;
            }
        }
    }

    private void showAllCases() throws IOException {
        sendMessage(caseService.findAll().toString());
    }

    private void createCase() throws IOException {
        caseService.add(parseCases());
    }

    private void changeCase() throws IOException {
        caseService.update(parseCases());
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

    private Case parseCases() throws IOException {
        sendMessage("Please enter card num");
        var cardNum = getMessageFromClient();
        sendMessage("Please enter faculty");
        var faculty = getMessageFromClient();
        sendMessage("Please enter specialty");
        var specialty = getMessageFromClient();
        sendMessage("Please enter name");
        var name = getMessageFromClient();
        sendMessage("Please enter surname");
        var surname = getMessageFromClient();

        return new Case(cardNum, faculty, specialty, name, surname);
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
