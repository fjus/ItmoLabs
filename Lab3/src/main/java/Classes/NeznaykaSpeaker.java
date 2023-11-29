package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class NeznaykaSpeaker extends Neznayka implements ICanSpeak {
    public NeznaykaSpeaker(Role role, String name) {
        super(role, name);
    }

    @Override
    public void speak() {
        System.out.println("Я Незнайка");
    }
}
