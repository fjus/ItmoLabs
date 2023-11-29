package Classes;

import Enums.Role;

public  abstract class Sproots extends Billionaire{

    public Sproots(Role role, String name, int billions) {
        super(role, name, billions);
    }

    @Override
    public String toString() {
        return "Sproots{"+
                "name: "+super.getName()+" "+
                "wealth: "+super.getBillions()+" billions "+" "+
                "role: "+super.getRole()+
                "}";
    }
}
