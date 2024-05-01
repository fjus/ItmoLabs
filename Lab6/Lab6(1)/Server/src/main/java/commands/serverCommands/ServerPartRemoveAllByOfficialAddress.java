package commands.serverCommands;

import classModel.Organization;
import managers.CollectionManager;
import utils.ExecutionResponse;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Команда 'remove_all_by_official_address'. Удаляет элементы, имеющие определенный адрес, из коллекции.
 * @author DenisLukash
 */
public class ServerPartRemoveAllByOfficialAddress extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartRemoveAllByOfficialAddress(CollectionManager collectionManager) {
        super("remove_all_by_official_address", "удаляет из коллекции все элементы, значение "+
                "поля official_address которых равно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        List<Organization> list;
        list = collectionManager.getCollection().stream().filter((Organization o) -> (!o.getOfficialAddress().equals(command.getOrganization().getOfficialAddress()))).collect(Collectors.toList());
        Stack<Organization> stack = new Stack<>();
        stack.addAll(list);
        collectionManager.setCollection(stack);
        return new ExecutionResponse("Все организации с таким адресом были успешны удалены");
    }
}
