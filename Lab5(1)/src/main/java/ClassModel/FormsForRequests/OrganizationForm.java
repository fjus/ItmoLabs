package ClassModel.FormsForRequests;


import ClassModel.Address;
import ClassModel.Coordinates;
import ClassModel.Organization;
import ClassModel.OrganizationType;
import Utils.Console;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

public class OrganizationForm {
    private final Console console;

    public OrganizationForm(Console console){
        this.console=console;
    }


    /**
     * Запрашивает у пользователя организацию.
     * @return организацию.
     */
    public Organization createOrganization(long id, Date date) {
        if (console.getFileScanner() == null) {
            try {
                String name;
                Coordinates coordinates;
                Date creationDate;
                Integer annualTurnover;
                OrganizationType type;
                Address officialAddress;
                while (true) {
                    console.println("Введите имя организации: ");
                    String line = console.readln().trim();
                    try {
                        if (line.equals("") || line.equals("null")) throw new Exception();
                        name = line;
                        break;
                    } catch (Exception e) {
                        console.printError("Hекорректный аргумент");
                    }
                }
                coordinates = new CoordinatesForm(console).createCoordinates();
                creationDate =date==null? new Date(new Random().nextLong(Long.MAX_VALUE)) : date;
                while (true) {
                    console.println("Введите ежегодный оборот компании: ");
                    String line = console.readln().trim();
                    try {
                        if (line.equals("null")) throw new NullPointerException();
                        annualTurnover = Integer.parseInt(line);
                        if (annualTurnover <= 0) throw new Exception();
                        break;
                    } catch (NumberFormatException e) {
                        console.printError("Hекорректный аргумент");
                    } catch (NullPointerException e){
                        annualTurnover = null;
                        break;
                    } catch (Exception e) {
                        console.printError("Hекорректный аргумент");
                    }
                }
                type = new OrganizationTypeForm(console).createOrganization();
                officialAddress = new AddressForm(console).createAddress();
                return new Organization(id, name, coordinates, creationDate, annualTurnover, type, officialAddress);

            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Ошибка чтения");
                return null;
            }
        }
        else{
            try {
                String name;
                Coordinates coordinates;
                Date creationDate;
                Integer annualTurnover;
                OrganizationType type;
                Address officialAddress;
                String line1 = console.readln().trim();
                    try {
                        if (line1.equals("") || line1.equals("null")) throw new Exception();
                        name = line1;
                    } catch (Exception e) {
                        name = null;
                    }
                coordinates = new CoordinatesForm(console).createCoordinates();
                creationDate =date==null? new Date(new Random().nextLong(Long.MAX_VALUE)) : date;
                annualTurnover = null;
                String line2 = console.readln().trim();
                    try {
                        annualTurnover = Integer.parseInt(line2);
                        if (annualTurnover < 0)  throw new Exception();
                    } catch (NumberFormatException e) {
                        annualTurnover = null;
                    } catch (Exception e) {
                    }
                type = new OrganizationTypeForm(console).createOrganization();
                officialAddress = new AddressForm(console).createAddress();
                return new Organization(id, name, coordinates, creationDate, annualTurnover, type, officialAddress);

            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Ошибка чтения");
                return null;
            }
        }
    }
}
