package co.com.jsierra.stepdefinitions;

import co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto;
import co.com.jsierra.questions.VerificarEmpleadoId;
import co.com.jsierra.tasks.ConsultarEmpleadoId;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto.CUERPO_RESPUESTA_INCORRECTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarEmpleadoIdStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Cuando("^el (.*) consulta informacion empleado con id (.*)$")
    public void actor_consulta_informacion_empleado(String actor, String id) {
        theActorCalled(actor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl")))
                .attemptsTo(
                        ConsultarEmpleadoId.enServicio(id)
                );
    }

    @Entonces("^deberia obtener la informacion del empleado$")
    public void deberia_obtener_informacion_empleado() {
        theActorInTheSpotlight().should(seeThat(VerificarEmpleadoId.deLaRespuesta())
                .orComplainWith(CuerpoRespuestaIncorrecto.class, CUERPO_RESPUESTA_INCORRECTO));
    }
}
