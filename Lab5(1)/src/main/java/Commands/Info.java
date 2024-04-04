package Commands;

import Managers.CollectionManager;
import Utils.Console;
import Utils.ExecutionResponse;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Команда 'info'. Выводит информацию о коллекции.
 * @author DenisLukash
 */
public class Info extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public Info(Console console, CollectionManager collectionManager) {
        super("info", "показывает информацию о коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(String[] arguments) {
        if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        LocalDateTime lastInitTime = collectionManager.getLastInitTime();
        String lastInitTimeString = (lastInitTime == null) ? "в данной сессии инициализации еще не происходило" :
                lastInitTime.toLocalDate().toString() + " " + lastInitTime.toLocalTime().toString();
        String s="Сведения о коллекции:\n";
        s+=" Тип: " + collectionManager.getCollection().getClass().toString()+"\n";
        s+=" Количество элементов: " + collectionManager.getCollection().size()+"\n";
        s+=" Дата последней инициализации: " + lastInitTimeString;
        return new ExecutionResponse(s);
    }
}
