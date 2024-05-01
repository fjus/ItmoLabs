package classModel;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Класс-компаратор для сравнения типов организаций.
 * @author DenisLukash
 */
public class OrganizationComparatorByType implements Comparator<Organization>, Serializable {
    @Override
    public int compare(Organization o1, Organization o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
