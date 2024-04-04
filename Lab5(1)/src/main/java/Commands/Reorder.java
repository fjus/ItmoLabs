package Commands;

import ClassModel.Organization;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

import java.util.Collections;
import java.util.Stack;

/**
 * Команда 'reorder'. Сортирует коллекцию в обратном порядке.
 * @author DenisLukash
 */
public class Reorder extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public Reorder(Console console, CollectionManager collectionManager) {
        super("reorder", "сортирует коллекцию в обратном порядке");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        collectionManager.updateInRightOrder();
        return new ExecutionResponse("Коллекция отсортирована в обратном порядке!");
    }
}
