package Classes;

import Enums.Role;

public abstract class TypicalMoonCitizen extends MoonShortie{
    public TypicalMoonCitizen(Role role, String name, City city) throws ImpossibleRole {
        super(role, name, city);
    }
}
