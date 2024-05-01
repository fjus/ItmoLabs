package classModel;

import utils.Validatable;

import java.io.Serializable;

/**
 * Перечисление типов организации.
 * @author DenisLukash
 */
public enum OrganizationType implements Validatable, Serializable {
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
