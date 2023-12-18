package Classes;

import Enums.Role;
import interfaces.ICanSpeak;

public class Julio extends TypicalMoonCitizen implements ICanSpeak {

    public Julio(Role role, String name, City city)  throws ImpossibleRole{
        super(role, name, city);
    }

    @Override
    public String toString() {
        return "{Julio"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+" "+
                "city: "+super.getCity()+
                "}";
    }
    @Override
    public void speak() {
        System.out.println("Я Джулио");
    }
}
