package Classes;

import Enums.Role;

public class Migo extends TypicalMoonCitizen{
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
}
