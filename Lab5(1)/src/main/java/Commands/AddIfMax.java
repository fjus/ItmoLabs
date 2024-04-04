package Commands;

import ClassModel.FormsForRequests.OrganizationForm;
import ClassModel.Organization;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

/**
 * Команда 'add_if_max'. Добавляет организацию в коллекцию, если она наибольшая.
 * @author DenisLukash
 */
public class AddIfMax extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public AddIfMax(Console console, CollectionManager collectionManager) {
        super("add_if_max", "добавляет указанный элемент в коллекцию, если он наибольший");
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

        if (o != null && o.getAnnualTurnover()>collectionManager.getCollection().get(0).getAnnualTurnover() && o.getAnnualTurnover()>collectionManager.getCollection().get(collectionManager.getCollection().size()-1).getAnnualTurnover() ) {
            collectionManager.add(o);
            collectionManager.update();
            return new ExecutionResponse("Организация успешно добавлена!");
        }
        if (!(o.getAnnualTurnover()>collectionManager.getCollection().get(0).getAnnualTurnover() && o.getAnnualTurnover()>collectionManager.getCollection().get(collectionManager.getCollection().size()-1).getAnnualTurnover())){
            return new ExecutionResponse(false,"Элемент коллекции не наибольший! Организация не добавлена в коллекцию!");
        }
        else return new ExecutionResponse(false,"Поля организации не валидны! Организация не создана!");
    }
}
