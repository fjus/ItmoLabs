package Classes;

import Enums.Role;

public abstract class MoonShortie extends Shortie {

    private City city;

    public MoonShortie(Role role, String name, City city) throws ImpossibleRole {
        super(role, name);
        this.city=city;
    }
    public static class City{
        public City(String name, String specialization){
            this.name=name;
            this.specialization=specialization;
        }
        public String name;
        public String specialization;

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", specialization='" + specialization + '\'' +
                    '}';
        }
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
