package commands.commandClientPart;

import utils.Console;
import utils.ExecutionResponse;
import classModel.Address;
import classModel.formsForRequests.AddressForm;
import classModel.Organization;

/**
 * Команда 'remove_all_by_official_address'. Удаляет элементы, имеющие определенный адрес, из коллекции.
 * @author DenisLukash
 */
public class ClientPartRemoveAllByOfficialAddress extends Command {
    private final Console console;
    private Organization organization;

    public ClientPartRemoveAllByOfficialAddress(Console console) {
        super("remove_all_by_official_address", "удаляет из коллекции все элементы, значение "+
                "поля official_address которых равно заданному");
        this.console = console;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        if(console.getFileScanner()==null) console.println("* Создание нового адреса:");
        Address address = new AddressForm(console).createAddress();
        if(address!=null && address.validate()){
            Organization o = new Organization(0L, null, null, null, null, null, address);
            setOrganization(o);
            return new ExecutionResponse("");
        }
        else return new ExecutionResponse(false, "Адресс не валиден!");
    }
}
