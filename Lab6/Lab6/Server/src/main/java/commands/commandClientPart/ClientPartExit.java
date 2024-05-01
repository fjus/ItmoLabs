package commands.commandClientPart;

import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'exit'. Останавливает программу.
 * @author DenisLukash
 */
public class ClientPartExit extends Command {
    private final Console console;

    public ClientPartExit(Console console) {
        super("exit", "завершает программу");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("exit");
    }
}
