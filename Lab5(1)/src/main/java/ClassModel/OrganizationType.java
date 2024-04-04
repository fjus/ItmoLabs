package ClassModel;

import Utils.Validatable;

/**
 * Перечисление типов организации.
 * @author DenisLukash
 */
public enum OrganizationType implements Validatable {
    PUBLIC,
    PRIVATE_LIMITED_COMPANY,
    TRUST;


    @Override
    public boolean validate() {
        if(this.equals(OrganizationType.PUBLIC) || this.equals(OrganizationType.TRUST) || this.equals(OrganizationType.PRIVATE_LIMITED_COMPANY)){
            return true;
        }
        else {
            return false;
        }
    }
}
