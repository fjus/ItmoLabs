package utils;

import java.io.Serializable;

/**
 * Класс ExecutionResponse. Отвечает за хранение результатов исполнения программ.
 * @author DenisLukash
 */
public class ExecutionResponse implements Serializable {
    private boolean exitCode;
    private String message;

    public ExecutionResponse(boolean code, String s) {
        exitCode = code;
        message = s;
    }

    public ExecutionResponse(String s) {
        this(true, s);
    }

    public boolean getExitCode() { return exitCode; }
    public String getMessage() {
        return message;
    }
    public String toString() { return String.valueOf(exitCode)+";"+message+";";}
}
