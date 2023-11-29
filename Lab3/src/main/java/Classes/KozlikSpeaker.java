package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class KozlikSpeaker extends Kozlik implements ICanSpeak {
    public KozlikSpeaker(Role role, String name) {
        super(role, name);
    }

    @Override
    public void speak() {
        System.out.println("Я Козлик");
    }
}
