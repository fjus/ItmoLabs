package managers;

import commands.commandClientPart.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс CommandManager. Отвечает за хранение и передачу списка команд.
 * @author DenisLukash
 */
public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Записывает команду в список команд.
     */
    public void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Возвращает список команд.
     */
    public Map<String, Command> getCommands() {
        return commands;
    }

}
