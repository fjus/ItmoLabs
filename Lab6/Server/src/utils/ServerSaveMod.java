package utils;

import commands.Save;
import managers.CollectionManager;

public class ServerSaveMod extends ServerInteractiveMode{
    private CollectionManager collectionManager;

    public ServerSaveMod(CollectionManager collectionManager, Console console){
        super(console);
        this.collectionManager = collectionManager;
    }
    @Override
    public void run() {
        String userAnswer;
        Console console = getConsole();
        while (true){
            console.println("Сохранить коллекцию?");
            userAnswer = console.readln().trim();
            if(userAnswer.toLowerCase().equals("да")){
                Save save = new Save(console, collectionManager);
                ExecutionResponse executionResponse = save.checkCommand(new String[]{"save", ""});
                console.println(executionResponse.getMessage());
                break;
            }
            else if(userAnswer.toLowerCase().equals("нет")){
                break;
            }
        }

    }
}
