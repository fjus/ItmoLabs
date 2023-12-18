package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class Neznayka extends EarthShortie implements ICanSpeak {
    public Neznayka(Role role, String name) throws ImpossibleRole {
        super(role, name);
    }

    @Override
    public String toString() {
        return "{Neznayka"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+
                "}";
    }
    @Override
    public void speak() {
        System.out.println("Я Незнайка");
    }
}
