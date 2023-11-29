package Classes;

import Enums.Role;

public class Neznayka extends EarthShortie{
    public Neznayka(Role role, String name) {
        super(role, name);
    }

    @Override
    public String toString() {
        return "{Neznayka"+
                "name: "+super.getName()+" "+
                "role: "+super.getRole()+
                "}";
    }
}
