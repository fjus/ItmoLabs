package commands.commandClientPart;

import classModel.Organization;
import utils.ExecutionResponse;

import java.io.Serializable;

/**
 * Абстрактная команда с названием и описанием.
 * @author DenisLukash
 */
public abstract class Command implements Serializable {
    private final String name;
    private final String description;
    private Organization organization;

    public Command(String name, String description){
        this.description=description;
        this.name=name;
    }

    /**
     * @return Описание команды.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Название комарнды.
     */
    public String getName() {
        return name;
    }

    /**
     * Реализует команду.
     */
    public abstract ExecutionResponse checkCommand(String[] arguments);

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getOrganization(){return this.organization;}

}
