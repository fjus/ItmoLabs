package commands.commandClientPart;

import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'show'. Выводит все элементы коллекции.
 * @author DenisLukash
 */
public class ClientPartShow extends Command {
    private final Console console;

    public ClientPartShow(Console console) {
        super("show", "выводит все элементы коллекции");
        this.console = console;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("");
    }
}
