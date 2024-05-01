package commands.commandClientPart;

import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'clear'. Очищает коллекцию.
 * @author DenisLukash
 */
public class ClientPartClear extends Command {
    private final Console console;

    public ClientPartClear(Console console) {
        super("clear", "очищает коллекцию");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty())
            return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("");
    }
}
