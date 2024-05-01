package commands.serverCommands;

import managers.CollectionManager;
import utils.ExecutionResponse;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;

/**
 * Команда 'reorder'. Сортирует коллекцию в обратном порядке.
 * @author DenisLukash
 */
public class ServerPartReorder extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartReorder(CollectionManager collectionManager) {
        super("reorder", "сортирует коллекцию в обратном порядке");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        collectionManager.updateInRightOrder();
        return new ExecutionResponse("Коллекция отсортирована в обратном порядке!");
    }
}
