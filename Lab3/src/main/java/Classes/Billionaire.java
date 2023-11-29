package Classes;

import Enums.Role;

public abstract class Billionaire extends MoonShortie{
    private int billions;

    public Billionaire(Role role, String name, int billions) {
        super(role, name);
        this.billions=billions;
    }

    public int getBillions() {
        return billions;
    }

    public void setBillions(int billions) {
        this.billions = billions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Billionaire that = (Billionaire) o;
        return billions == that.billions;
    }

    @Override
    public int hashCode() {
        return super.getRole().ordinal()*19+super.getName().length()*23+billions*29;
    }
}
