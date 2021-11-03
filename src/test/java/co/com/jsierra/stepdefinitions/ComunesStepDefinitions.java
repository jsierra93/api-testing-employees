package co.com.jsierra.stepdefinitions;

import co.com.jsierra.exceptions.StatusCodeIncorrecto;
import co.com.jsierra.questions.VerificarCodigoRespuesta;
import cucumber.api.java.es.Entonces;

import static co.com.jsierra.exceptions.StatusCodeIncorrecto.STATUS_CODE_INCORRECTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ComunesStepDefinitions {

    @Entonces("^deberia obtener status code (.*)$")
    public void deberia_obtener_respuesta_exitosa(int code) {
        theActorInTheSpotlight().should(seeThat(VerificarCodigoRespuesta.deLaRespuesta(code)).orComplainWith(StatusCodeIncorrecto.class, STATUS_CODE_INCORRECTO));
    }
}
