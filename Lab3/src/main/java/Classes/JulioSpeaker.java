package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class JulioSpeaker extends Julio implements ICanSpeak {

    public JulioSpeaker(Role role, String name) {
        super(role, name);
    }

    @Override
    public void speak() {
        System.out.println("Я Джулио");
    }
}
