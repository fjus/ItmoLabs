package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class SprootsSpeaker extends Sproots implements ICanSpeak {
    public SprootsSpeaker(Role role, String name, int billions) {
        super(role, name, billions);
    }

    @Override
    public void speak() {
        System.out.println("Я Спрутс");
    }
}
