package ClassModel.FormsForRequests;


import ClassModel.Coordinates;
import ClassModel.Location;
import Utils.Console;

import java.util.NoSuchElementException;

public class CoordinatesForm {
    private final Console console;

    public CoordinatesForm(Console console){
        this.console=console;
    }

    /**
     * Запрашивает у пользователя координаты.
     * @return координаты.
     */
    public Coordinates createCoordinates() {
        if(console.getFileScanner()==null) {
            try {
                Long x;
                Long y;
                while (true) {
                    console.println("Введите координату X: ");
                    String line = console.readln().trim();
                    if(line.equals("null")){
                        x=null;
                        break;
                    }
                    try {
                        if(line.equals("null")) throw new NullPointerException();
                        x = Long.parseLong(line);
                        if (x > 694) throw new Exception();
                        break;
                    } catch (NullPointerException e){
                        x = null;
                        break;
                    } catch (Exception e) {
                        console.printError("Hекорректный аргумент");
                    }
                }
                while (true) {
                    console.println("Введите координату Y: ");
                    String line = console.readln().trim();
                    try {
                        y = Long.parseLong(line);
                        break;
                    } catch (Exception e) {
                        console.printError("Hекорректный аргумент");
                    }
                }

                return new Coordinates(x, y);

            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Ошибка чтения");
                return null;
            }
        }
        else{
            try {
                Long x;
                Long y;
                String line1 = console.readln().trim();
                    try {
                        if(line1.equals("null")) throw new NullPointerException();
                        x = Long.parseLong(line1);
                        if (x > 694) throw new Exception();
                    } catch(NullPointerException e){
                        x = null;
                    } catch (Exception e) {
                        x = null;
                    }
                String line2 = console.readln().trim();
                    try {
                        y = Long.parseLong(line2);
                    } catch (Exception e) {
                        y = null;
                    }

                return new Coordinates(x, y);

            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Ошибка чтения");
                return null;
            }

        }
    }

}
