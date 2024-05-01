import commands.commandClientPart.*;
import managers.CommandManager;
import network.TCPClient;
import utils.*;
import utils.Console;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {
    public static void main(String[] args) {
        Console console = new StandardConsole();

        CommandManager commandManager = new CommandManager() {{
            register("help", new ClientPartHelp(console, this));
            register("info", new ClientPartInfo(console));
            register("show", new ClientPartShow(console));
            register("add", new ClientPartAdd(console));
            register("update", new ClientPartUpdate(console));
            register("remove_by_id", new ClientPartRemoveById(console));
            register("clear", new ClientPartClear(console));
            register("execute_script", new ClientPartExecuteScript(console));
            register("exit", new ClientPartExit(console));
            register("add_if_min", new ClientPartAddIfMin(console));
            register("add_if_max", new ClientPartAddIfMax(console));
            register("print_field_ascending_type", new ClientPartPrintFieldAscendingType(console));
            register("reorder", new ClientPartReorder(console));
            register("remove_all_by_official_address", new ClientPartRemoveAllByOfficialAddress(console));
            register("filter_starts_with_name", new ClientPartFilterStartsWithName(console));
        }};
        TCPClient tcpClient = null;
        try {
            tcpClient = new TCPClient(console,new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8000));
        } catch (UnknownHostException e) {
            console.printError("Неизвестное имя хоста");
        }
        Runner runner = new Runner(console, commandManager, tcpClient);
        runner.interactiveMode();








    }

}
