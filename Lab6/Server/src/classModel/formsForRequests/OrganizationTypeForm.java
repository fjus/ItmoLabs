package classModel.formsForRequests;

import classModel.OrganizationType;
import utils.*;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class OrganizationTypeForm implements Serializable {
    private final Console console;

    public OrganizationTypeForm(Console console){
        this.console=console;
    }


    /**
     * Запрашивает у пользователя тип организации.
     * @return тип организации.
     */
    public OrganizationType createOrganization() {
        if(console.getFileScanner()==null) {
            try {
                OrganizationType organizationType;
                while (true) {
                    console.println("Введите тип организации: ");
                    console.println("TRUST");
                    console.println("PUBLIC");
                    console.println("PRIVATE_LIMITED_COMPANY");
                    String line = console.readln().trim();
                    try {
                        organizationType = OrganizationType.valueOf(line);
                        break;
                    } catch (Exception e) {
                        console.printError("Hекорректный аргумент");
                    }
                }
                return organizationType;

            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Ошибка чтения");
                return null;
            }
        }
        else{
            try {
                OrganizationType organizationType;
                String line = console.readln().trim();
                    try {
                        organizationType = OrganizationType.valueOf(line);
                    } catch (Exception e) {
                        organizationType = null;
                    }

                return organizationType;

            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Ошибка чтения");
                return null;
            }
        }
    }
}
