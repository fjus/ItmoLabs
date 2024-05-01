package Commands;

import ClassModel.Organization;
import ClassModel.OrganizationType;
import Utils.*;

import java.util.Collections;
import java.util.Stack;

/**
 * Команда 'print_field_ascending_type'. Выводит тип организации всех элементов в порядке возрастания.
 * @author DenisLukash
 */
public class PrintFieldAscendingType extends Command{
    private final Console console;

    public PrintFieldAscendingType(Console console) {
        super("print_field_ascending_type", "выводит значения поля type всех элементов в пордке возрастания");
        this.console = console;
    }

    /**
     * Реализуют команду.
     */
    @Override
    public ExecutionResponse checkCommand(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        return new ExecutionResponse("");
    }

}
