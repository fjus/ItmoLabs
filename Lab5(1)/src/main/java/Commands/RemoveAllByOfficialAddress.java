package Commands;

import ClassModel.Address;
import ClassModel.FormsForRequests.AddressForm;
import ClassModel.Organization;
import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

import java.util.Collections;
import java.util.Stack;

/**
 * Команда 'remove_all_by_official_address'. Удаляет элементы, имеющие определенный адрес, из коллекции.
 * @author DenisLukash
 */
public class RemoveAllByOfficialAddress extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveAllByOfficialAddress(Console console, CollectionManager collectionManager) {
        super("remove_all_by_official_address", "удаляет из коллекции все элементы, значение "+
                "поля official_address которых равно заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        Stack<Organization> stack = new Stack<>();
        stack.addAll(collectionManager.getCollection());
        if(console.getFileScanner()==null) console.println("* Создание нового адреса:");
        Address address = new AddressForm(console).createAddress();
        if(address!=null){
            for(Organization organization : stack){
                if(organization.getOfficialAddress().equals(address)){
                    collectionManager.remove(organization.getId());
                }
            }
            collectionManager.update();
            return new ExecutionResponse("Все организации с таким адресом были успешны удалены");
        }
        else return new ExecutionResponse(false, "Поля Организации не валидны! Организация не создана!");
    }
}
