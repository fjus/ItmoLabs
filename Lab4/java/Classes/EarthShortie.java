package Classes;

import Enums.Role;

public abstract class EarthShortie extends Shortie{

    public EarthShortie(Role role, String name) throws ImpossibleRole {
        super(role, name);
    }
}
