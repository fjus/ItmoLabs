package Classes;

public class TooPoorToBeBillionaire extends RuntimeException{
    public TooPoorToBeBillionaire() {
        super("You are too poor for billionaire");
    }
}
