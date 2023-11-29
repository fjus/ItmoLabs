package Classes;

import Enums.Role;

public abstract class Dube extends Billionaire{


    public Dube(Role role, String name, int billions) {
        super(role, name, billions);
    }

    @Override
    public String toString() {
        return "Dube{"+
                "name: "+super.getName()+" "+
                "wealth: "+super.getBillions()+" billions"+" "+
                "role: "+super.getRole()+
                "}";
    }

}
