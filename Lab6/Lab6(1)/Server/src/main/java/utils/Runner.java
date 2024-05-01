package utils;

import commands.Exit;
import commands.Save;
import managers.CollectionManager;
import network.ClientHandler;
import java.net.Socket;


public class Runner {
    private Console console;
    CollectionManager collectionManager;

    public Runner(Console console, CollectionManager collectionManager){
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public boolean interactiveMode(){
            ExecutionResponse commandStatus;
            String[] userCommand = {"", ""};
            console.prompt();
            userCommand = (console.readln().trim() + " ").split(" ", 2);
            userCommand[0] = userCommand[0].trim();
            userCommand[1] = userCommand[1].trim();
            commandStatus = launchCommand(userCommand);
            if (commandStatus.getMessage().equals("exit")) {
                    return true;
            }
            console.println(commandStatus.getMessage());
            return false;
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
