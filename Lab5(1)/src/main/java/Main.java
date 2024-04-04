
import ClassModel.Location;
import ClassModel.OrganizationType;
import Commands.*;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.DumpManager;
import Utils.*;
import Utils.Console;
import java.io.*;



public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new StandardConsole();
        DumpManager dumpManager = new DumpManager(System.getenv("VAR1"), console);
        CollectionManager collectionManager = new CollectionManager(dumpManager);
        if (!collectionManager.init()) {
            System.err.println("Не удалось инициализировать коллекцию");
            System.exit(1);
        }

        var commandManager = new CommandManager() {{
            register("help", new Help(console, this));
            register("info", new Info(console, collectionManager));
            register("show", new Show(console, collectionManager));
            register("add", new Add(console, collectionManager));
            register("update", new Update(console, collectionManager));
            register("remove_by_id", new RemoveById(console, collectionManager));
            register("clear", new Clear(console, collectionManager));
            register("save", new Save(console, collectionManager));
            register("execute_script", new ExecuteScript(console));
            register("exit", new Exit(console));
            register("add_if_min", new AddIfMin(console, collectionManager));
            register("add_if_max", new AddIfMax(console, collectionManager));
            register("print_field_ascending_type", new PrintFieldAscendingType(console, collectionManager));
            register("reorder", new Reorder(console, collectionManager));
            register("remove_all_by_official_address", new RemoveAllByOfficialAddress(console, collectionManager));
            register("filter_starts_with_name", new FilterStartsWithName(console, collectionManager));
        }};

        Runner runner = new Runner(console, commandManager);
        runner.interactiveMode();









    }

}
