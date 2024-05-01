package classModel;

import utils.Validatable;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * Класс организации.
 * @author DenisLukash
 */
public class Organization implements Comparable<Organization>, Validatable, Serializable {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Integer annualTurnover;
    private OrganizationType type;
    private Address officialAddress;

    public Organization(Long id, String name, Coordinates coordinates, Date creationDate, Integer annualTurnover, OrganizationType type, Address officialAddress) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.officialAddress = officialAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Integer annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }

    /**
     * Превращает спиок строк в организацию.
     * @return организацию
     */
    public static Organization fromArray(String[] a) {
        Long id;
        String name;
        Date creationDate;
        Coordinates coordinates;
        Integer annualTurnover;
        OrganizationType type;
        Address address;
        try {
            try {
                id = Long.parseLong(a[0]);
            } catch (NumberFormatException e) { id = null; }
            name = a[1];
            try {
                creationDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(a[2]);
            } catch (ParseException e) { creationDate = null; }
            coordinates = new Coordinates(a[3]);
            try{
                annualTurnover = Integer.parseInt(a[4]);
            } catch (NumberFormatException e){annualTurnover = null;}
            try {
                type = a[5].equals("null") ? null : OrganizationType.valueOf(a[5]);
            } catch (NullPointerException | IllegalArgumentException  e) { type = null; }
            address = new Address(a[6]);
            return new Organization(id, name, coordinates, creationDate, annualTurnover, type, address);
        } catch (Exception e) {}
        return null;
    }


    /**
     * Превращает организацию в спиок строк.
     * @return спиок строк
     */
    public static String[] toArray(Organization o) {
        var list = new ArrayList<String>();
        list.add(""+o.getId());
        list.add(o.getName());
        list.add(o.getCreationDate().toString());
        list.add(o.getCoordinates().toString());
        list.add(""+o.getAnnualTurnover());
        list.add(o.getType() == null ? "null" : o.getType().toString());
        list.add(o.getOfficialAddress().toString());
        return list.toArray(new String[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return  Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(annualTurnover, that.annualTurnover) && type == that.type && Objects.equals(officialAddress, that.officialAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, annualTurnover, type, officialAddress);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", annualTurnover=" + annualTurnover +
                ", type=" + type +
                ", officialAddress=" + officialAddress +
                '}';
    }

    @Override
    public int compareTo(Organization o) {
        if(o.getAnnualTurnover()==null && this.getAnnualTurnover()==null){
            return 0;
        }
        else if(this.getAnnualTurnover()==null) {
            return -1;
        }
        else if(o.getAnnualTurnover()==null) {
            return 1;
        }
        else {
            return this.getAnnualTurnover() - o.getAnnualTurnover();
        }
    }

    /**
     * Проверяет правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if(id<=0) return false;
        if(name == null) return false;
        if(name.equals("") || name.equals("null")) return false;
        if(coordinates == null) return false;
        if(!coordinates.validate()) return false;
        if(creationDate==null) return false;
        if(annualTurnover!=null){
            if(annualTurnover<=0)  return false;
        }
        if(officialAddress == null) return false;
        if(!officialAddress.validate()) return false;
        if(type == null) return false;
        if(!type.validate()) return false;
        return true;
    }
}
