package commands.serverCommands;

import managers.CollectionManager;
import utils.ExecutionResponse;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;
/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции по id.
 * @author DenisLukash
 */
public class ServerPartRemoveById extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartRemoveById(CollectionManager collectionManager) {
        super("remove_by_id", "удаляет элемент из коллекции по его id");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        if (collectionManager.byId(command.getOrganization().getId()) == null || !collectionManager.getCollection().contains(collectionManager.byId(command.getOrganization().getId()))){
            return new ExecutionResponse(false, "Не существующий ID");
        }
        collectionManager.remove(command.getOrganization().getId());
        collectionManager.update();
        return new ExecutionResponse("Организация успешно удалена!");
    }
}
