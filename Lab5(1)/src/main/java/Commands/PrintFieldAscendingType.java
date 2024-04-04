package Commands;

import ClassModel.Organization;
import ClassModel.OrganizationComparatorByType;
import ClassModel.OrganizationType;
import Managers.CollectionManager;
import Utils.*;

import java.util.Collections;
import java.util.Stack;

/**
 * Команда 'print_field_ascending_type'. Выводит тип организации всех элементов в порядке возрастания.
 * @author DenisLukash
 */
public class PrintFieldAscendingType extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public PrintFieldAscendingType(Console console, CollectionManager collectionManager) {
        super("print_field_ascending_type", "выводит значения поля type всех элементов в пордке возрастания");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализуют команду.
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
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
