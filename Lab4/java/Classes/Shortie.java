package Classes;

import Enums.Role;

import java.util.Objects;

public abstract class Shortie{
    private Role role;
    private String name;

    public Shortie(Role role, String name) throws ImpossibleRole{
        if((this.getClass() == Sproots.class || this.getClass() == Dube.class) && role!=Role.VILLAIN){
            throw new ImpossibleRole("Moon billionaire cannot be hero or neutral character");
        }
        if(this.getClass() == Neznayka.class && role==Role.VILLAIN){
            throw new ImpossibleRole("Earth shortie cannot be villain");
        }
        this.role=role;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shortie shortie = (Shortie) o;
        return role == shortie.role && Objects.equals(name, shortie.name);
    }

    @Override
    public int hashCode() {
        return role.ordinal()*19+name.length()*23;
    }
}
