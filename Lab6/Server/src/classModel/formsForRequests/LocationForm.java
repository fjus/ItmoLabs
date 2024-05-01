package classModel.formsForRequests;


import classModel.Location;
import utils.*;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class LocationForm implements Serializable {
    private final Console console;

    public LocationForm(Console console){
        this.console=console;
    }


    /**
     * Запрашивает у пользователя локацию.
     * @return локацию.
     */
    public Location createLocation() {
        if (console.getFileScanner() == null) {
            while (true) {
                console.println("Локация является null?");
                String location = console.readln().trim();
                if (location.toLowerCase().equals("да")) {
                    return null;
                } else if (location.toLowerCase().equals("нет")) {
                    try {
                        Integer x;
                        Long y;
                        String name;
                        while (true) {
                            console.println("Введите координату X: ");
                            String line = console.readln().trim();
                            try {
                                x = Integer.parseInt(line);
                                break;
                            } catch (Exception e) {
                                console.printError("Hекорректный аргумент");
                            }
                        }
                        while (true) {
                            console.println("Введите координату Y: ");
                            String line = console.readln().trim();
                            try {
                                if (line.equals("null")) throw new NullPointerException();
                                y = Long.parseLong(line);
                                break;
                            } catch (NullPointerException e) {
                                y = null;
                                break;
                            } catch (Exception e) {
                                console.printError("Hекорректный аргумент");
                            }
                        }
                        while (true) {
                            console.println("Введите название города: ");
                            name = console.readln().trim();
                            try {
                                if (name.equals("null")) throw new Exception();
                                break;
                            } catch (Exception e) {
                                console.printError("Hекорректный аргумент");
                            }

                        }
                        return new Location(x, y, name);

                    } catch (NoSuchElementException | IllegalStateException e) {
                        console.printError("Ошибка чтения");
                        return null;
                    }
                }
            }
        }
        else    {
                String location = console.readln().trim();
                if (location.equals("null")) return null;
                try {
                    Integer x;
                    Long y;
                    String name;
                    String line1 = location;
                    try {
                        x = Integer.parseInt(line1);
                    } catch (Exception e) {
                        x = null;
                    }
                    String line2 = console.readln().trim();
                    try {
                        y = Long.parseLong(line2);
                    } catch (Exception e) {
                        y = null;
                    }
                    name = console.readln().trim();
                    try {
                        if (name.equals("null")) throw new Exception();
                    } catch (Exception e) {
                    }
                    return new Location(x, y, name);

                } catch (NoSuchElementException | IllegalStateException e) {
                    console.printError("Ошибка чтения");
                    return null;
                }
            }
        }


}
