package network;

import utils.ExecutionResponse;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Response {
    private final Socket socket;
    private final ExecutionResponse executionResponse;


    public Response(Socket socket, ExecutionResponse executionResponse)  {
        this.socket = socket;
        this.executionResponse = executionResponse;
    }

    public ExecutionResponse sendResponseFromServer() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        os.writeObject(executionResponse);
        os.flush();
        return executionResponse;
    }


}
