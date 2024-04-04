package Commands;

import ClassModel.Organization;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'show'. Выводит все элементы коллекции.
 * @author DenisLukash
 */
public class Show extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Show(Console console, CollectionManager collectionManager) {
        super("show", "выводит все элементы коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        return new ExecutionResponse(collectionManager.toString());
    }
}
