package co.com.jsierra.exceptions;

public class StatusCodeIncorrecto extends AssertionError {

    public static final String STATUS_CODE_INCORRECTO = "Status code no corresponde al esperado";

    public StatusCodeIncorrecto(String message, Throwable cause) {
        super(message, cause);
    }
}
