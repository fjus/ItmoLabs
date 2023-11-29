package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class MigoSpeaker extends Migo implements ICanSpeak {
    public MigoSpeaker(Role role, String name) {
        super(role, name);
    }

    @Override
    public void speak() {
        System.out.println("Я Миго");
    }
}
