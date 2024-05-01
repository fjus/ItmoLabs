package Commands;

import ClassModel.*;
import ClassModel.FormsForRequests.OrganizationForm;
import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'update'. Обновляет элемент по его id.
 * @author DenisLUkash
 */
public class Update extends Command{
    private final Console console;
    private Organization organization;

    public Update(Console console) {
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
