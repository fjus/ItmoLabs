import commands.Save;
import commands.commandClientPart.Command;
import commands.serverCommands.*;
import managers.CollectionManager;
import managers.DumpManager;
import network.ClientHandler;
import utils.*;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)  {
        Console console = new StandardConsole();
        DumpManager dumpManager = new DumpManager("file1.csv", console);
        CollectionManager collectionManager = new CollectionManager(dumpManager);
        if (!collectionManager.init()) {
            System.err.println("Не удалось инициализировать коллекцию");
            System.exit(1);
        }
        HashMap<String, ServerCommand> accordanceClientToServerCommand = new HashMap<>(){{
            put("add", new ServerPartAdd(collectionManager));
            put("add_if_max", new ServerPartAddIfMax(collectionManager));
            put("add_if_min", new ServerPartAddIfMin(collectionManager));
            put("clear", new ServerPartClear(collectionManager));
            put("filter_starts_with_name", new ServerPartFilterStartsWithName(collectionManager));
            put("info", new ServerPartInfo(collectionManager));
            put("remove_all_by_official_address", new ServerPartRemoveAllByOfficialAddress(collectionManager));
            put("remove_by_id", new ServerPartRemoveById(collectionManager));
            put("reorder", new ServerPartReorder(collectionManager));
            put("show", new ServerPartShow(collectionManager));
            put("update", new ServerPartUpdate(collectionManager));
            put("print_field_ascending_type", new ServerPartPrintFieldAscendingType(collectionManager));
        }};
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            console.printError("Проблемы с получением сокета сервера");
            collectionManager.saveCollection();
            System.exit(1);
        }
        Executor executor = new Executor(accordanceClientToServerCommand);
        ClientHandler clientHandler = new ClientHandler(serverSocket, console);
        Runner runner = new Runner(console, collectionManager);
        while (true){
            clientHandler.run(executor);
            Save save = new Save(console, collectionManager);
            save.checkCommand(new String[]{"save", ""});
            boolean isCont = runner.interactiveMode();
            if (isCont){
                break;
            }
        }



    }

}
