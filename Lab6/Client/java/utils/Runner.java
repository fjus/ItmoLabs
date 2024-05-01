package utils;

import commands.commandClientPart.Command;
import managers.CommandManager;
import network.TCPClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Интерфейс Runner. Отвечает за запуск приложения и первичную обработку ввода.
 * @author DenisLukash
 */
public class Runner {
    private Console console;
    private CommandManager commandManager;
    private TCPClient tcpClient;
    private List<String> scriptStack = new ArrayList<>();
    private final int lengthRecursion = 2;


    public Runner(Console console, CommandManager commandManager, TCPClient tcpClient) {
        this.console = console;
        this.commandManager = commandManager;
        this.tcpClient = tcpClient;
    }

    /**
     * Интерактивный режим
     */
    public void interactiveMode()  {
            ExecutionResponse commandStatus;
            String[] userCommand = {"", ""};
            tcpClient.connectToServer();
            while (true) {
                try {
                console.prompt();
                userCommand = (console.readln().trim() + " ").split(" ", 2);
                userCommand[0] = userCommand[0].trim();
                userCommand[1] = userCommand[1].trim();
                if(tcpClient.getSc()==null && !userCommand[0].equals("help")){
                        tcpClient.connectToServer();
                }
                try{
                    commandStatus = launchCommand(userCommand);
                } catch (IOException | ClassNotFoundException e){
                    throw  new RuntimeException();
                }

                if (commandStatus.getMessage().equals("exit")){
                    break;
                }

                console.println(commandStatus.getMessage());
            } catch (Exception e) {
                    console.printError("Непредвиденная ошибка");
                }
            }
            tcpClient.close();

    }

    private boolean checkRecursion(String argument) {
            int counter=0;
            for(String scriptName : scriptStack){
                if(scriptName.equals(argument)){
                    counter++;
                }
                if(counter>lengthRecursion) return false;
            }
            return true;
    }

    /**
     * Режим для запуска скрипта.
     * @param argument Аргумент скрипта
     * @return Код завершения.
     */
    private ExecutionResponse scriptMode(String argument) throws IOException, ClassNotFoundException {
        String[] userCommand = {"", ""};
        StringBuilder executionOutput = new StringBuilder();

        if (!new File(argument).exists()) return new ExecutionResponse(false, "Файл не существет!");
        if (!Files.isReadable(Paths.get(argument))) return new ExecutionResponse(false, "Прав для чтения нет!");

        scriptStack.add(argument);
        try (Scanner scriptScanner = new Scanner(new File(argument))) {

            ExecutionResponse commandStatus;

            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            console.selectFileScanner(scriptScanner);
            do {
                userCommand = (console.readln().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (console.isCanReadln() && userCommand[0].isEmpty()) {
                    userCommand = (console.readln().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                }
                executionOutput.append(console.getPrompt() + String.join(" ", userCommand) + "\n");
                boolean needLaunch = true;
                if (userCommand[0].equals("execute_script")) {
                    needLaunch = checkRecursion(userCommand[1]);
                }

                commandStatus = needLaunch ? launchCommand(userCommand) : new ExecutionResponse("Превышена глубина рекурсии");
                if (userCommand[0].equals("execute_script")) console.selectFileScanner(scriptScanner);
                executionOutput.append(commandStatus.getMessage()+"\n");
            } while (!commandStatus.getMessage().equals("exit") && console.isCanReadln());

            console.selectConsoleScanner();

            return new ExecutionResponse(commandStatus.getExitCode(), executionOutput.toString());
        } catch (FileNotFoundException exception) {
            return new ExecutionResponse(false, "Файл со скриптом не найден!");
        } catch (NoSuchElementException exception) {
            return new ExecutionResponse(false, "Файл со скриптом пуст!");
        } catch (IllegalStateException exception) {
            console.printError("Непредвиденная ошибка!");
            System.exit(0);
        } finally {
            scriptStack.remove(scriptStack.size()-1);
        }
        return new ExecutionResponse("");
    }



    /**
     * Загружает команды.
     * @param userCommand Команда для запуска
     * @return Код завершения.
     */
    private ExecutionResponse launchCommand(String[] userCommand) throws IOException, ClassNotFoundException {
        if (userCommand[0].equals("")) return new ExecutionResponse("");
        Command command = commandManager.getCommands().get(userCommand[0]);

        if (command == null) return new ExecutionResponse(false, "Команда '" + userCommand[0] + "' не найдена.");

        switch (userCommand[0]) {
            case "execute_script":
                ExecutionResponse response1 = command.checkCommand(userCommand);
                if(response1.getExitCode()){
                    ExecutionResponse response2 = scriptMode(userCommand[1]);
                    return new ExecutionResponse(response2.getExitCode(), "\n"+response2.getMessage().trim());
                }
                else{
                    return new ExecutionResponse(response1.getMessage());
                }
            case "help":
                return command.checkCommand(userCommand);
            case "exit":
                return  command.checkCommand(userCommand);
            default:
                ExecutionResponse response4 = command.checkCommand(userCommand);
                if(response4.getExitCode()) {
                    ExecutionResponse response5;
                    response5 = tcpClient.run(command);
                    return new ExecutionResponse(response5.getExitCode(), "\n"+response5.getMessage().trim());
                }
                else{
                    return new ExecutionResponse(response4.getMessage());
                }

        }
        }
    }

