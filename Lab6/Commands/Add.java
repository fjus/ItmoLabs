package Commands;

import ClassModel.*;
import ClassModel.FormsForRequests.OrganizationForm;
import Utils.Console;
import Utils.ExecutionResponse;

import java.io.Serializable;

/**
 * Команда 'add'. Добавляет организацию в коллекцию.
 * @author DenisLukash
 */
public class Add extends Command {
    private final Console console;
    private Organization organization;

    public Add(Console console) {
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
