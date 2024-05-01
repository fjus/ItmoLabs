package commands.serverCommands;

import managers.CollectionManager;
import utils.ExecutionResponse;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;
/**
 * Команда 'show'. Выводит все элементы коллекции.
 * @author DenisLukash
 */
public class ServerPartShow extends ServerCommand {
    private final CollectionManager collectionManager;
    public ServerPartShow(CollectionManager collectionManager) {
        super("show", "выводит все элементы коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        return new ExecutionResponse(collectionManager.toString());
    }
}
