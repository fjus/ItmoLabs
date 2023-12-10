package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class Migo extends TypicalMoonCitizen implements ICanSpeak {
    public Migo(Role role, String name) {
        super(role, name);
    }

    @Override
    public String toString() {
        return "{Migo"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+
                "}";
    }

    @Override
    public void speak() {
        System.out.println("Я Миго");
    }
}
