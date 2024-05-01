package utils;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Интерфейс Console. Отвечает за работу с консолью .
 * @author DenisLukash
 */
public interface Console extends Serializable {
    void print(Object o);
    void println(Object o);
    String readln();
    boolean isCanReadln();
    void printError(Object o);
    void selectFileScanner(Scanner o);
    void selectConsoleScanner();

    Scanner getFileScanner();

}
