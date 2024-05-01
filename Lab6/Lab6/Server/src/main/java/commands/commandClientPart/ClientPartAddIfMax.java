package commands.commandClientPart;

import utils.Console;
import utils.ExecutionResponse;
import classModel.formsForRequests.OrganizationForm;
import classModel.Organization;

/**
 * Команда 'add_if_max'. Добавляет организацию в коллекцию, если она наибольшая.
 * @author DenisLukash
 */
public class ClientPartAddIfMax extends Command {
    private final Console console;
    private Organization organization;

    public ClientPartAddIfMax(Console console) {
        super("add_if_max", "добавляет указанный элемент в коллекцию, если он наибольший");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String arguments[]) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        if(console.getFileScanner()==null) console.println("* Создание новой организации:");
        Organization o = new OrganizationForm(console).createOrganization(0, null);

        if (o != null && o.validate()) {
            setOrganization(o);
            return new ExecutionResponse("");
        } else return new ExecutionResponse(false,"Поля организации не валидны! Организация не создана!");
    }
}
