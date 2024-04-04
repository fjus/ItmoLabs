package Commands;

import ClassModel.Organization;
import Managers.CollectionManager;
import Utils.*;

import java.util.Stack;

/**
 * Команда 'filter_starts_with_name'. Выводит значение полей, имена которых начинается с определенного слова.
 * @author DenisLukash
 */
public class FilterStartsWithName extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public FilterStartsWithName(Console console, CollectionManager collectionManager) {
        super("filter_starts_with_name","выводит элементы, значение поля name которых начинается "+
                "с заданной подстроки");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments){
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        Stack<Organization> stack = new Stack<>();
        for(Organization o : collectionManager.getCollection()){
            if(o.getName().startsWith(arguments[1])){
                stack.push(o);
            }
        }
        if (stack.isEmpty()) return new ExecutionResponse("Организаций начинающихся с этого имени нету!");
        else{
            StringBuilder info = new StringBuilder();
            for (Organization organization : stack) {
                info.append(organization+"\n\n");
            }
            return new ExecutionResponse(info.toString().trim());
        }
    }
}
