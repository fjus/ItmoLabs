package commands.serverCommands;

import utils.ExecutionResponse;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;

/**
 * Абстрактная команда с названием и описанием.
 * @author DenisLukash
 */
public abstract class ServerCommand {
    private final String name;
    private final String description;

    public ServerCommand(String name, String description){
        this.description=description;
        this.name=name;
    }

    /**
     * @return Описание команды.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Название комарнды.
     */
    public String getName() {
        return name;
    }

    /**
     * Реализует команду.
     */
    public abstract ExecutionResponse commandRealization(Command command);

}
