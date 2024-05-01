package Commands;

import ClassModel.Organization;
import Utils.Console;
import Utils.ExecutionResponse;

import java.util.HashMap;
import java.util.Stack;

/**
 * Команда 'clear'. Очищает коллекцию.
 * @author DenisLukash
 */
public class Clear extends Command{
    private final Console console;

    public Clear(Console console) {
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
