package network;

import commands.commandClientPart.Command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Request {
    private SocketChannel sh;
    private Command command;

    public Request(SocketChannel sh, Command command){
        this.sh = sh;
        this.command = command;
    }

    public void sendRequest() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(command);
        os.flush();
        ByteBuffer buffer = ByteBuffer.allocate(bos.toByteArray().length);
        buffer.clear();
        buffer.put(bos.toByteArray());
        buffer.flip();
        sh.write(buffer);
        bos.close();
        os.close();

    }
}
