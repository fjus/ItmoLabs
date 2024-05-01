package classModel;

import utils.Validatable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс адресса.
 * @author DenisLukash
 */
public class Address implements Validatable, Serializable {
    private String street;
    private Location town;

    public Address(String street, Location town) {
        this.street = street;
        this.town = town;
    }

    public Address(String s) {
        try {
            if(s.split(",").length>2) throw new ArrayIndexOutOfBoundsException();
            try {
                this.street = s.split(",")[0];
            } catch (Exception e) {
            }
            if (s.split(",")[1].equals("null")) {
                this.town = null;
            }
            else {
                try {
                    this.town = new Location(s.split(",")[1]);
                } catch (Exception e) {
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){

        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Location getTown() {
        return town;
    }

    public void setTown(Location town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return street+","+town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(town, address.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, town);
    }

    /**
     * Проверяет правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if(street == null) return false;
        if(street.length()>140 || street.equals("null")) return false;
        if(town==null) return true;
        if(!town.validate()) return false;
        return true;
    }
}
