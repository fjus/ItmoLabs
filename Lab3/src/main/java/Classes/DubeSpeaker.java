package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class DubeSpeaker extends Dube implements ICanSpeak {
    public DubeSpeaker(Role role, String name, int billions) {
        super(role, name, billions);
    }

    @Override
    public void speak() {
        System.out.println("Я Дубе");
    }
}
