package utils;

import commands.commandClientPart.Command;
import commands.serverCommands.ServerCommand;
import java.util.HashMap;

public class Executor {
    private final HashMap<String, ServerCommand> accordanceClientToServerCommands;

    public Executor(HashMap<String, ServerCommand> accordanceClientToServerCommands){
        this.accordanceClientToServerCommands = accordanceClientToServerCommands;
    }


    public ExecutionResponse executeCommand(Command command){
        return accordanceClientToServerCommands.get(command.getName()).commandRealization(command);
    }

}
