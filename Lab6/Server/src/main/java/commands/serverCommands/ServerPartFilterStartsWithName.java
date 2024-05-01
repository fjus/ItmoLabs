package commands.serverCommands;

import classModel.Organization;
import managers.CollectionManager;
import utils.*;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import commands.commandClientPart.Command;
import commands.commandClientPart.*;
/**
 * Команда 'filter_starts_with_name'. Выводит значение полей, имена которых начинается с определенного слова.
 * @author DenisLukash
 */
public class ServerPartFilterStartsWithName extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartFilterStartsWithName(CollectionManager collectionManager) {
        super("filter_starts_with_name","выводит элементы, значение поля name которых начинается "+
                "с заданной подстроки");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(Command command){
        List<Organization> list;
        list = collectionManager.getCollection().stream().filter((Organization o) -> (o.getName().startsWith(command.getOrganization().getName()))).collect(Collectors.toList());
        if (list.isEmpty()) return new ExecutionResponse("Организаций начинающихся с этого имени нету!");
        else{
            StringBuilder info = new StringBuilder();
            for (Organization organization : list) {
               info.append(organization+"\n\n");
            }
            return new ExecutionResponse(info.toString().trim());
        }

    }
}
