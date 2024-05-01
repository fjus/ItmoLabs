package Commands;

import Utils.Console;
import Utils.ExecutionResponse;

import java.time.LocalDateTime;

/**
 * Команда 'info'. Выводит информацию о коллекции.
 * @author DenisLukash
 */
public class Info extends Command{
    private final Console console;

    public Info(Console console) {
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
