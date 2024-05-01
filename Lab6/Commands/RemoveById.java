package Commands;

import ClassModel.Organization;
import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции по id.
 * @author DenisLukash
 */
public class RemoveById extends Command{
    private final Console console;
    private Organization organization;

    public RemoveById(Console console) {
        super("remove_by_id", "удаляет элемент из коллекции по его id");
        this.console = console;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        long id = -1;
        try {
            id = Long.parseLong(arguments[1].trim());
            Organization o = new Organization(id, null, null, null, null, null, null);
            setOrganization(o);

        } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }
        return new ExecutionResponse("");
    }
}
