package utils;

public abstract class ServerInteractiveMode {
    private Console console;

    public ServerInteractiveMode(Console console){
        this.console = console;
    }

    public abstract void run();

    public Console getConsole() {
        return console;
    }
}
