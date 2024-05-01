package utils;

import commands.Exit;
import commands.Save;
import managers.CollectionManager;
import network.ClientHandler;
import java.net.Socket;


public class Runner {
    private Console console;
    CollectionManager collectionManager;
    ClientHandler clientHandler;
    Executor executor;

    public Runner(Console console, CollectionManager collectionManager, ClientHandler clientHandler, Executor executor){
        this.console = console;
        this.collectionManager = collectionManager;
        this.clientHandler = clientHandler;
        this.executor = executor;
    }

    public void run(){
            ExecutionResponse commandStatus;
            String[] userCommand = {"", ""};
            while (true) {
                clientHandler.connectToClient();
                clientHandler.run(executor);
                userCommand = (console.readln().trim() + " ").split(" ", 2);
                userCommand[0] = userCommand[0].trim();
                userCommand[1] = userCommand[1].trim();
                commandStatus = launchCommand(userCommand);
                if (commandStatus.getMessage().equals("exit")) {
                    break;
                }
                console.println(commandStatus.getMessage());
            }

    }

    private ExecutionResponse launchCommand(String[] userCommand)  {
        if (userCommand[0].equals("")) return new ExecutionResponse("");

        switch (userCommand[0]) {
            case "exit":
                Exit exit = new Exit(console);
                ExecutionResponse response1 = exit.checkCommand(userCommand);
                return response1;
            case "save":
                Save save = new Save(console, collectionManager);
                ExecutionResponse response2 = save.checkCommand(userCommand);
                return response2;
            default:
                ExecutionResponse response3 = new ExecutionResponse("Команда не найдена");
                return response3;
        }
    }

}
