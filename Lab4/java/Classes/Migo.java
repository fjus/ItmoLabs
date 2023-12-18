package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class Migo extends TypicalMoonCitizen implements ICanSpeak {
    public Migo(Role role, String name, City city) throws ImpossibleRole {
        super(role, name, city);
    }

    @Override
    public String toString() {
        return "{Migo"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+" "+
                "city: "+super.getCity()+
                "}";
    }

    @Override
    public void speak() {
        System.out.println("Я Миго");
    }
}
