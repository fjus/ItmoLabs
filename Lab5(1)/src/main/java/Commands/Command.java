package Commands;

import Utils.ExecutionResponse;

/**
 * Абстрактная команда с названием и описанием.
 * @author DenisLukash
 */
public abstract class Command {
    private final String name;
    private final String description;

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
    public abstract ExecutionResponse commandRealization(String[] arguments);

}
