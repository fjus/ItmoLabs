package commands.commandClientPart;

import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'reorder'. Сортирует коллекцию в обратном порядке.
 * @author DenisLukash
 */
public class ClientPartReorder extends Command {
    private final Console console;

    public ClientPartReorder(Console console) {
        super("reorder", "сортирует коллекцию в обратном порядке");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("");
    }
}
