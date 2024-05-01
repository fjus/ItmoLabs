package commands.commandClientPart;


import utils.ExecutionResponse;

import java.io.Console;

/**
 * Команда 'execute_script'. Исполняет скрипт из указанного файла.
 * @author DenisLukash
 */
public class ClientPartExecuteScript extends Command {
    private final Console console;
    public ClientPartExecuteScript(Console console) {
        super("execute_script", "Считывает и исполняет скрипт из указанного файла");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("");
    }

}
