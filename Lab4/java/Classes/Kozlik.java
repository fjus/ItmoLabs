package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class Kozlik extends TypicalMoonCitizen implements ICanSpeak {

    public Kozlik(Role role, String name, City city) throws ImpossibleRole {
        super(role, name, city);
    }

    @Override
    public String toString() {
        return "{Kozlik"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+" "+
                "city: "+super.getCity()+
                "}";

    }

    @Override
    public void speak() {
        System.out.println("Я Козлик");
    }
}
