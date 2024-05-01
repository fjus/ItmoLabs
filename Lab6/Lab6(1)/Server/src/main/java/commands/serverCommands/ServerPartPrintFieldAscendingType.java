package commands.serverCommands;

import classModel.Organization;
import classModel.OrganizationType;
import managers.CollectionManager;
import utils.*;
import commands.commandClientPart.Command;
import commands.commandClientPart.*;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Команда 'print_field_ascending_type'. Выводит тип организации всех элементов в порядке возрастания.
 * @author DenisLukash
 */
public class ServerPartPrintFieldAscendingType extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartPrintFieldAscendingType(CollectionManager collectionManager) {
        super("print_field_ascending_type", "выводит значения поля type всех элементов в пордке возрастания");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализуют команду.
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
        Stack<OrganizationType> stack = new Stack<>();
        for(Organization o : collectionManager.getCollection()){
            stack.push(o.getType());
        }
        Collections.sort(stack);
        String s="";
        for (OrganizationType organizationType: stack)
            s+=" " + organizationType;
        return new ExecutionResponse(s);
    }

}
