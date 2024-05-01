package commands.commandClientPart;

import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'info'. Выводит информацию о коллекции.
 * @author DenisLukash
 */
public class ClientPartInfo extends Command {
    private final Console console;

    public ClientPartInfo(Console console) {
        super("info", "показывает информацию о коллекции");
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
