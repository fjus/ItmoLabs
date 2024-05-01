package commands;

import commands.commandClientPart.Command;
import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'save'. Сохраняет коллекцию в файл.
 * @author DenisLukash
 */
public class Save extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super("save", "сохраняет коллекцию в файл");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        collectionManager.saveCollection();
        return new ExecutionResponse(true, "");
    }
}
