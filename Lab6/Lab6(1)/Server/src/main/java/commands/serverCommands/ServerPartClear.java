package commands.serverCommands;

import classModel.Organization;
import managers.CollectionManager;
import utils.ExecutionResponse;

import java.util.HashMap;
import java.util.Stack;

import commands.commandClientPart.Command;
import commands.commandClientPart.*;
/**
 * Команда 'clear'. Очищает коллекцию.
 * @author DenisLukash
 */
public class ServerPartClear extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartClear(CollectionManager collectionManager) {
        super("clear", "очищает коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        collectionManager.setCollection(new Stack<Organization>());
        collectionManager.setOrganizations(new HashMap<Long, Organization>());
        collectionManager.update();
        return new ExecutionResponse("Коллекция очищена!");
    }
}
