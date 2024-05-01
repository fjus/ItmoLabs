package classModel.formsForRequests;


import classModel.Address;
import classModel.Location;
import utils.Console;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class AddressForm implements Serializable {
    private final Console console;

    public AddressForm(Console console){
        this.console=console;
    }


    /**
     * Запрашивает у пользователя адресс.
     * @return адресс.
     */
    public Address createAddress() {
        if (console.getFileScanner() == null) {
            try {
                String street;
                Location location;
                while (true) {
                    if (console.getFileScanner() == null) console.println("Введите название улицы: ");
                    street = console.readln().trim();
                    try {
                        if (street.length() > 140 || street.equals("null")) throw new Exception();
                        break;
                    } catch (Exception e) {
                        console.printError("Hекорректный аргумент");
                    }
                }
                location = new LocationForm(console).createLocation();
                return new Address(street, location);

            } catch (NoSuchElementException | IllegalStateException e) {
                console.println("Ошибка чтения");
                return null;
            }
        }
        else{
            try {
                String street;
                Location location;
                street = console.readln().trim();
                    try {
                        if (street.length() > 140 || street.equals("null")) throw new Exception();
                    } catch (Exception e) {
                        street = null;
                    }
                location = new LocationForm(console).createLocation();
                return new Address(street, location);

            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Ошибка чтения");
                return null;
            }
        }

    }


}
