package Commands;

import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'show'. Выводит все элементы коллекции.
 * @author DenisLukash
 */
public class Show extends Command{
    private final Console console;

    public Show(Console console) {
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
