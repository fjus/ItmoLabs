package network;

import commands.commandClientPart.Command;
import utils.Console;
import utils.ExecutionResponse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class TCPClient {
    private SocketChannel sc;
    private InetSocketAddress inetAddress;
    private Console console;

    public TCPClient(Console console, InetSocketAddress inetAddress){
        this.console = console;
        this.inetAddress = inetAddress;
    }

    public void connectToServer() {
        try{
            this.sc = SocketChannel.open();
            sc.connect(inetAddress);

        } catch (IOException e) {
            console.printError("Подключение к серверу не удалось");
            this.sc = null;
        }
    }

    public void close() {
        if(sc!=null) {
            try {
                this.sc.close();
            } catch (IOException e) {
                console.printError("Не удалось разорвать соединение");
            }
        }
    }

    public ExecutionResponse get() {
        if(sc!=null) {
            Response response = new Response(sc);
            try {
                ExecutionResponse executionResponse = response.getResponseFromServer();
                return executionResponse;
            } catch (IOException e) {
                console.printError("Не удалось получить ответ от сервера");
                this.sc = null;
            } catch (ClassNotFoundException e) {
                console.printError("Не удается распознать файл, отправленный сервером");
                this.sc = null;
            }
        }
        return null;
    }

    public void send(Command command)  {
        if(sc!=null) {
            Request request = null;
            request = new Request(sc, command);
            try {
                request.sendRequest();
            } catch (IOException e) {
                console.printError("Не удалось отправить запрос серверу");
                this.sc = null;
            }
        }
    }

    public ExecutionResponse run(Command command){
        ExecutionResponse executionResponse;
        if(sc!=null) {
            send(command);
            executionResponse = get();
            if (executionResponse == null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    console.printError("Не удалось разорвать соединение с сервером");
                }
            }
            return executionResponse;
        }
        return new ExecutionResponse("");
    }

    public SocketChannel getSc() {
        return sc;
    }
}
