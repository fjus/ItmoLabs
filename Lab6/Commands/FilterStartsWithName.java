package Commands;

import ClassModel.Organization;
import Utils.*;

import java.util.Stack;

/**
 * Команда 'filter_starts_with_name'. Выводит значение полей, имена которых начинается с определенного слова.
 * @author DenisLukash
 */
public class FilterStartsWithName extends Command{
    private final Console console;

    public FilterStartsWithName(Console console) {
        super("filter_starts_with_name","выводит элементы, значение поля name которых начинается "+
                "с заданной подстроки");
        this.console = console;
    }

    /**
     * Реализует команду
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments){
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("");
    }
}
