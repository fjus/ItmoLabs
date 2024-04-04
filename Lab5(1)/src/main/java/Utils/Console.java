package Utils;

import java.util.Scanner;

/**
 * Интерфейс Console. Отвечает за работу с консолью .
 * @author DenisLukash
 */
public interface Console {
    void print(Object o);
    void println(Object o);
    String readln();
    boolean isCanReadln();
    void printError(Object o);
    void prompt();
    String getPrompt();
    void selectFileScanner(Scanner o);
    void selectConsoleScanner();

    Scanner getFileScanner();

}
