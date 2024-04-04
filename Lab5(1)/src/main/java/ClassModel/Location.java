package ClassModel;

import Utils.Validatable;

import java.util.Objects;

/**
 * Класс локации.
 * @author DenisLukash
 */
public class Location implements Validatable {
    private Integer x;
    private Long y;
    private String name;

    public Location(Integer x, Long y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Location(String s) {
        try {
            if(s.split("#").length>3) throw new ArrayIndexOutOfBoundsException();
            try { this.x = Integer.parseInt(s.split("#")[0]); } catch (Exception e) { }
            try {
                if(s.split("#")[1].equals("null")) throw new NullPointerException();
                this.y = Long.parseLong(s.split("#")[1]);
            } catch(NullPointerException e){
                this.y = null;
            } catch (Exception e) { }
            try { this.name = s.split("#")[2]; } catch (Exception e){ }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    public long getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && Objects.equals(y, location.y) && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, name);
    }

    @Override
    public String toString() {
        return x+"#"+y+"#"+name;
    }

    /**
     * Проверяет правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if(this == null) return true;
        if(x==null) return false;
        if(name == null) return false;
        if(name.equals("null")) return false;
        return true;
    }
}
