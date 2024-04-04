package Commands;

import ClassModel.*;
import ClassModel.FormsForRequests.OrganizationForm;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'update'. Обновляет элемент по его id.
 * @author DenisLUkash
 */
public class Update extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public Update(Console console, CollectionManager collectionManager) {
        super("update", "обновляет элемент коллекции по соответствующему id");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        long id = -1;
        try { id = Long.parseLong(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }

        Organization old = collectionManager.byId(id);
        if (old == null || !collectionManager.getCollection().contains(old)) {
            return new ExecutionResponse(false, "Не существующий ID");
        }

        if(console.getFileScanner()==null) console.println("* Создание новой организации:");
        Organization o = new OrganizationForm(console).createOrganization(id, old.getCreationDate());
        if (o != null) {
            collectionManager.remove(old.getId());
            collectionManager.add(o);
            collectionManager.update();
            return new ExecutionResponse("Обновлено!");
        } else {
            return new ExecutionResponse(false, "Поля Организации не валидны! Организация не создана!");
        }
    }
}
