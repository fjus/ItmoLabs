package commands.commandClientPart;

import managers.CommandManager;
import utils.Console;
import utils.ExecutionResponse;

import java.util.stream.Collectors;


/**
 * Команда 'help'. Выводит доступные команды и их описание.
 * @author DenisLukash
 */
public class ClientPartHelp extends Command {
    private final Console console;
    private final CommandManager commandManager;

    public ClientPartHelp(Console console, CommandManager commandManager) {
        super("help", "выводит справку по доступным командам");
        this.console = console;
        this.commandManager = commandManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse(commandManager.getCommands().values().stream().map(command -> String.format(" %-35s%-1s%n", command.getName(), command.getDescription())).collect(Collectors.joining("\n")));
    }

}
