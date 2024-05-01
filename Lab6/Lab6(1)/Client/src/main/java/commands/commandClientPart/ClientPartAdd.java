package commands.commandClientPart;

import classModel.Organization;
import classModel.formsForRequests.OrganizationForm;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'add'. Добавляет организацию в коллекцию.
 * @author DenisLukash
 */
public class ClientPartAdd extends Command {
    private final Console console;
    private Organization organization;

    public ClientPartAdd(Console console) {
        super("add", "добавляет указанный элемент в коллекцию");
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
