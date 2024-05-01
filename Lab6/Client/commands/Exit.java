package commands;

import commands.commandClientPart.Command;
import utils.Console;
import utils.ExecutionResponse;

public class Exit extends Command {
    private final Console console;

    public Exit(Console console) {
        super("exit", "завершает работу сервера");
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
