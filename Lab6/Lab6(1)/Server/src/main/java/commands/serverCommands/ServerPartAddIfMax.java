package commands.serverCommands;

import classModel.Address;
import classModel.Coordinates;
import classModel.Organization;
import classModel.OrganizationType;
import managers.CollectionManager;
import utils.ExecutionResponse;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;

import java.util.Date;
import java.util.Random;

/**
 * Команда 'add_if_max'. Добавляет организацию в коллекцию, если она наибольшая.
 * @author DenisLukash
 */
public class ServerPartAddIfMax extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartAddIfMax(CollectionManager collectionManager) {
        super("add_if_max", "добавляет указанный элемент в коллекцию, если он наибольший");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        Coordinates coordinates = command.getOrganization().getCoordinates();
        Long id = collectionManager.getFreeId();
        String name = command.getOrganization().getName();
        Date creationDate = new Date(new Random().nextLong(Long.MAX_VALUE));
        Integer annualTurnover = command.getOrganization().getAnnualTurnover();
        OrganizationType type = command.getOrganization().getType();
        Address address = command.getOrganization().getOfficialAddress();
        Organization o = new Organization(id, name, coordinates, creationDate, annualTurnover, type, address);
        if (o.getAnnualTurnover()>collectionManager.getCollection().get(0).getAnnualTurnover() && o.getAnnualTurnover()>collectionManager.getCollection().get(collectionManager.getCollection().size()-1).getAnnualTurnover() ) {
            collectionManager.add(o);
            collectionManager.update();
            return new ExecutionResponse("Организация успешно добавлена!");
        }
       else {
            return new ExecutionResponse(false,"Элемент коллекции не наибольший! Организация не добавлена в коллекцию!");
        }
    }
}
