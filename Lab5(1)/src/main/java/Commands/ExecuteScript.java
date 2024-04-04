package Commands;


import Utils.Console;
import Utils.ExecutionResponse;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Команда 'execute_script'. Исполняет скрипт из указанного файла.
 * @author DenisLukash
 */
public class ExecuteScript extends Command{
    private final Console console;
    public ExecuteScript(Console console) {
        super("execute_script", "Считывает и исполняет скрипт из указанного файла");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("");
    }

}
