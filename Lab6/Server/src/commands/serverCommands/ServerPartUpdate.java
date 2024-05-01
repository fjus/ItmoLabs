package commands.serverCommands;

import classModel.*;
import managers.CollectionManager;
import utils.ExecutionResponse;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;
/**
 * Команда 'update'. Обновляет элемент по его id.
 * @author DenisLUkash
 */
public class ServerPartUpdate extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartUpdate(CollectionManager collectionManager) {
        super("update", "обновляет элемент коллекции по соответствующему id");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        Organization old = collectionManager.byId(command.getOrganization().getId());
        if (old == null || !collectionManager.getCollection().contains(old)) {
            return new ExecutionResponse(false, "Не существующий ID");
        }
        Coordinates coordinates = command.getOrganization().getCoordinates();
        String name = command.getOrganization().getName();
        Integer annualTurnover = command.getOrganization().getAnnualTurnover();
        OrganizationType type = command.getOrganization().getType();
        Address address = command.getOrganization().getOfficialAddress();
        Organization o = new Organization(command.getOrganization().getId(), name, coordinates, collectionManager.byId(command.getOrganization().getId()).getCreationDate(), annualTurnover, type, address);
        collectionManager.remove(old.getId());
        collectionManager.add(o);
        collectionManager.update();
        return new ExecutionResponse("Обновлено!");
    }
}
