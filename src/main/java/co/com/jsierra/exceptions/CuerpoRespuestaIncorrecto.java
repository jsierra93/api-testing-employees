package co.com.jsierra.exceptions;

public class CuerpoRespuestaIncorrecto extends AssertionError {

    public static final String CUERPO_RESPUESTA_INCORRECTO = "Cuerpo de respuesta no corresponde al esperado";

    public CuerpoRespuestaIncorrecto(String message, Throwable cause) {
        super(message, cause);
    }
}
