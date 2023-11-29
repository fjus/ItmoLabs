package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class Julio extends TypicalMoonCitizen implements ICanSpeak {

    public Julio(Role role, String name) {
        super(role, name);
    }

    @Override
    public String toString() {
        return "{Julio"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+
                "}";
    }
    @Override
    public void speak() {
        System.out.println("Я Джулио");
    }
}
