package Classes;

import Enums.Role;

public abstract class Billionaire extends MoonShortie{
    private int billions;
    private Bredlam bredlam;

    public Billionaire(Role role, String name, int billions, String bredlamName, City city) throws ImpossibleRole {
        super(role, name, city);
        Bredlam bredlam = new Bredlam(bredlamName);
        this.bredlam=bredlam;
        if(billions<2){
            throw new TooPoorToBeBillionaire();
        }
        else {
            this.billions = billions;
        }
    }


    class Bredlam{
        Bredlam(String name){
            this.name=name;
        }
        public String name;

        @Override
        public String toString() {
            return "Bredlam{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public int getBillions() {
        return billions;
    }

    public void setBillions(int billions) {
        this.billions = billions;
    }

    public Bredlam getBredlam() {
        return bredlam;
    }

    public void setBredlam(Bredlam bredlam) {
        this.bredlam = bredlam;
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
