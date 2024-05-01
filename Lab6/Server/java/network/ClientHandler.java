package network;

import commands.commandClientPart.Command;
import utils.Console;
import utils.ExecutionResponse;
import utils.Executor;
import utils.Runner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler {
    private ServerSocket socket;
    private Console console;
    private Socket clientSocket;

    public ClientHandler(ServerSocket socket, Console console){
        this.socket = socket;
        this.console = console;
    }

    public void connectToClient() {
        if(clientSocket==null) {
            try {
                this.clientSocket = socket.accept();
            } catch (IOException e) {
                console.printError("Подключение клиента не удалось");
            }
        }
    }

    public void close(Socket socket) {
        try{
            socket.close();
        } catch (IOException e){
            console.printError("Не удалось разорвать соединение");
        }
    }

    public Command get(Socket socket) {
        try {
            Request request = new Request(socket);
            Command command = request.getRequest();
            return command;
        } catch (IOException e) {
            console.printError("Не удалось получить запрос клиента");

        } catch (ClassNotFoundException e) {
            console.printError("Не удается распознать файл, отправленный клиентом");
        }
        return null;
    }

    public void send(Socket socket, ExecutionResponse executionResponse)  {
        Response response = null;
        response = new Response(socket, executionResponse);
        try {
            response.sendResponseFromServer();
        } catch (Exception e) {
            console.printError("Не удалось отправить ответ клиенту");
        }
    }

    public void run(Executor executor){
            if(clientSocket!=null){
            Command command = get(clientSocket);
            if(command==null || command.getName().equals("exit")){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    console.printError("Не удалось разорвать соединение с клиентом");
                } finally {
                    return;
                }
            }
            ExecutionResponse executionResponse = executor.executeCommand(command);
            send(clientSocket, executionResponse);
            }
    }



}
