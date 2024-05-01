package utils;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс StandardConsole. Отвечает за ввод и вывод.
 * @author DenisLukash
 */
public class StandardConsole implements Console{

    private static Scanner fileScanner = null;
    private static Scanner defScanner = new Scanner(System.in);

    /**
     * Выводит o.toString() в консоль
     * @param o Объект для печати
     */
    @Override
    public void print(Object o) {
        System.out.print(o);
    }

    /**
     * Выводит o.toString()+\n в консоль
     * @param o Объект для печати
     */
    @Override
    public void println(Object o) {
        System.out.println(o);
    }


    @Override
    public String readln() throws NoSuchElementException, IllegalStateException {
        return (fileScanner!=null?fileScanner:defScanner).nextLine();
    }

    /**
     * Проверяет можно ли дальше считывать данные из консоли.
     */
    @Override
    public boolean isCanReadln() throws IllegalStateException {
        return (fileScanner!=null?fileScanner:defScanner).hasNextLine();
    }

    @Override
    public void printError(Object o) {
        System.err.println("Error."+o);
    }

    @Override
    public void selectFileScanner(Scanner scanner) {
        StandardConsole.fileScanner=scanner;
    }

    @Override
    public void selectConsoleScanner() {
        StandardConsole.fileScanner = null;
    }

    @Override
    public Scanner getFileScanner() {
        return fileScanner;
    }


}
