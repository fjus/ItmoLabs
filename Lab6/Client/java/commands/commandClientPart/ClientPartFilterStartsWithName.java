package commands.commandClientPart;

import classModel.Organization;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'filter_starts_with_name'. Выводит значение полей, имена которых начинается с определенного слова.
 * @author DenisLukash
 */
public class ClientPartFilterStartsWithName extends Command {
    private final Console console;

    public ClientPartFilterStartsWithName(Console console) {
        super("filter_starts_with_name","выводит элементы, значение поля name которых начинается "+
                "с заданной подстроки");
        this.console = console;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments){
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        setOrganization(new Organization(null, arguments[1], null, null, null, null, null));
        return new ExecutionResponse("");
    }
}
