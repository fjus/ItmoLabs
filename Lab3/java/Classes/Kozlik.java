package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class Kozlik extends TypicalMoonCitizen implements ICanSpeak {

    public Kozlik(Role role, String name) {
        super(role, name);
    }

    @Override
    public String toString() {
        return "{Kozlik"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+
                "}";

    }

    @Override
    public void speak() {
        System.out.println("Я Козлик");
    }
}
