package commands.serverCommands;

import classModel.*;
import managers.CollectionManager;
import utils.ExecutionResponse;

import java.util.Date;
import java.util.Random;

import commands.commandClientPart.Command;
import commands.commandClientPart.*;
/**
 * Команда 'add'. Добавляет организацию в коллекцию.
 * @author DenisLukash
 */
public class ServerPartAdd extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartAdd(CollectionManager collectionManager) {
        super("add", "добавляет указанный элемент в коллекцию");
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
        collectionManager.add(o);
        collectionManager.update();
        return new ExecutionResponse("Организация успешно добавлена!");
    }

}
