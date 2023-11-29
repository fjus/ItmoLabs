package Classes;

import Enums.Role;

public class Julio extends TypicalMoonCitizen{

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
}
