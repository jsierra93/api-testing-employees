package co.com.jsierra.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerificarCodigoRespuesta implements Question<Boolean>{

    private int code;

    public VerificarCodigoRespuesta(int code) {
        this.code = code;
    }

    public static VerificarCodigoRespuesta deLaRespuesta(int code){
        return new VerificarCodigoRespuesta(code);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == code;
    }
}
