package commands.commandClientPart;

import classModel.Organization;
import classModel.formsForRequests.OrganizationForm;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Команда 'update'. Обновляет элемент по его id.
 * @author DenisLUkash
 */
public class ClientPartUpdate extends Command {
    private final Console console;
    private Organization organization;

    public ClientPartUpdate(Console console) {
        super("update", "обновляет элемент коллекции по соответствующему id");
        this.console = console;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        long id = -1;
        try {
            id = Long.parseLong(arguments[1].trim());

        } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }

        if(console.getFileScanner()==null) console.println("* Создание новой организации:");
        Organization o = new OrganizationForm(console).createOrganization(id, null);
        if (o != null && o.validate()) {
            setOrganization(o);
            return new ExecutionResponse("");
        } else {
            return new ExecutionResponse(false, "Поля Организации не валидны! Организация не создана!");
        }
    }
}
