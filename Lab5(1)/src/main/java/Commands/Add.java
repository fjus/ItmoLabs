package Commands;

import ClassModel.*;
import ClassModel.FormsForRequests.OrganizationForm;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'add'. Добавляет организацию в коллекцию.
 * @author DenisLukash
 */
public class Add extends Command  {
    private final Console console;
    private final CollectionManager collectionManager;

    public Add(Console console, CollectionManager collectionManager) {
        super("add", "добавляет указанный элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(String arguments[]) {
            if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

            if(console.getFileScanner()==null) console.println("* Создание новой организации:");
            Organization o = new OrganizationForm(console).createOrganization(collectionManager.getFreeId(), null);

            if (o != null && o.validate()) {
                collectionManager.add(o);
                collectionManager.update();
                return new ExecutionResponse("Организация успешно добавлена!");
            } else return new ExecutionResponse(false,"Поля организации не валидны! Организация не создана!");
    }



}
