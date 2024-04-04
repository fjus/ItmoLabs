package ClassModel;

import Utils.Validatable;

import java.util.Objects;

/**
 * Класс координат.
 * @author DenisLukash
 */
public class Coordinates implements Validatable {
    private Long x;
    private Long y;

    public Coordinates(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(String s) {
        try {
            if(s.split(",").length>2) throw new ArrayIndexOutOfBoundsException();
            try {
                if(s.split(",")[0].equals("null")) throw new NullPointerException();
                this.x = Long.parseLong(s.split(",")[0]);
            } catch(NullPointerException e){
                this.x = null;
            } catch (Exception e) {

            }
            try { this.y = Long.parseLong(s.split(",")[1]); }catch (Exception e) { }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return y == that.y && Objects.equals(x, that.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x+","+y;
    }

    /**
     * Проверяет правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if(x!=null) {
            if (x > 694) return false;
        }
        if(y==null) return false;
        return true;
    }
}
