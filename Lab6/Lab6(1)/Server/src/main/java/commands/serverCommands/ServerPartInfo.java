package commands.serverCommands;

import managers.CollectionManager;
import utils.ExecutionResponse;

import java.time.LocalDateTime;

import commands.commandClientPart.Command;
import commands.commandClientPart.*;
/**
 * Команда 'info'. Выводит информацию о коллекции.
 * @author DenisLukash
 */
public class ServerPartInfo extends ServerCommand {
    private final CollectionManager collectionManager;

    public ServerPartInfo(CollectionManager collectionManager) {
        super("info", "показывает информацию о коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду.
     */
    @Override
    public ExecutionResponse commandRealization(Command command) {
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
