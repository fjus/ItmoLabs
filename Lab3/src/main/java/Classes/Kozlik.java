package Classes;

import Enums.Role;

public class Kozlik extends TypicalMoonCitizen{

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
}
