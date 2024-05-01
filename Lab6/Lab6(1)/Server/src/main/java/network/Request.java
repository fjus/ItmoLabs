package network;

import commands.commandClientPart.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Request {
    private final Socket socket;

    public Request(Socket socket) {
        this.socket = socket;
    }

    public Command getRequest() throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Command command = (Command) is.readObject();
        return command;
    }


}
