package Commands;

import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'reorder'. Сортирует коллекцию в обратном порядке.
 * @author DenisLukash
 */
public class Reorder extends Command{
    private final Console console;

    public Reorder(Console console) {
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
