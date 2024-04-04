package Commands;

import ClassModel.Organization;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

import java.util.HashMap;
import java.util.Stack;

/**
 * Команда 'clear'. Очищает коллекцию.
 * @author DenisLukash
 */
public class Clear extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "очищает коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (!arguments[1].isEmpty())
            return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        collectionManager.setCollection(new Stack<Organization>());
        collectionManager.setOrganizations(new HashMap<Long, Organization>());
        collectionManager.update();
        return new ExecutionResponse("Коллекция очищена!");
    }
}
