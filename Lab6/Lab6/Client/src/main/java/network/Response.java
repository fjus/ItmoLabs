package network;

import utils.ExecutionResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Response {
    private SocketChannel sh;
    private ExecutionResponse executionResponse;

    public Response(SocketChannel sh){
        this.sh = sh;
    }

    public ExecutionResponse getResponseFromServer() throws IOException, ClassNotFoundException{
        ByteBuffer buffer = ByteBuffer.allocate(500_000_000);
        buffer.clear();
        sh.read(buffer);
        buffer.flip();
        byte[] byteArr = new byte[buffer.remaining()];
        buffer.get(byteArr);
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
        ObjectInputStream is = new ObjectInputStream(bis);
        ExecutionResponse er = (ExecutionResponse) is.readObject();
        bis.close();
        is.close();
        return er;
    }
}
