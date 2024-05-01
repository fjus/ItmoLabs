package network;

import commands.commandClientPart.Command;
import utils.Console;
import utils.ExecutionResponse;
import utils.Executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler {
    private ServerSocket socket;
    private Console console;

    public ClientHandler(ServerSocket socket, Console console){
        this.socket = socket;
        this.console = console;
    }

    public Socket connectToClient() {
        try{
            Socket clientSocket = socket.accept();
            return clientSocket;
        } catch (IOException e){
            console.printError("Подключение клиента не удалось");
        }
        return null;
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
        Socket clientSocket = connectToClient();
        while(true){
            if(clientSocket==null){
                break;
            }
            Command command = get(clientSocket);
            if(command==null || command.getName().equals("exit")){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    console.printError("Не удалось разорвать соединение с клиентом");
                }finally {
                    break;
                }
            }
            ExecutionResponse executionResponse = executor.executeCommand(command);
            send(clientSocket, executionResponse);
        }
    }



}
