package Commands;

import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'exit'. Останавливает программу.
 * @author DenisLukash
 */
public class Exit extends Command{
    private final Console console;

    public Exit(Console console) {
        super("exit", "завершает программу");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        return new ExecutionResponse("exit");
    }
}
