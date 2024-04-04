package Commands;

import ClassModel.Organization;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

import java.util.Stack;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции по id.
 * @author DenisLukash
 */
public class RemoveById extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveById(Console console, CollectionManager collectionManager) {
        super("remove_by_id", "удаляет элемент из коллекции по его id");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        long id = -1;
        try { id = Long.parseLong(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }

        if (collectionManager.byId(id) == null || !collectionManager.getCollection().contains(collectionManager.byId(id))){
            return new ExecutionResponse(false, "Не существующий ID");
        }
        collectionManager.remove(id);
        collectionManager.update();
        return new ExecutionResponse("Организация успешно удалена!");
    }
}
