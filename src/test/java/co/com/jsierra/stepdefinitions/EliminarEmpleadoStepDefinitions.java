package co.com.jsierra.stepdefinitions;

import co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto;
import co.com.jsierra.models.Empleado;
import co.com.jsierra.questions.VerificarCreacionEmpleado;
import co.com.jsierra.questions.VerificarEliminacionEmpleado;
import co.com.jsierra.tasks.CrearEmpleado;
import co.com.jsierra.tasks.EliminarEmpleado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;

import static co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto.CUERPO_RESPUESTA_INCORRECTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarEmpleadoStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Cuando("^el (.*) quiere eliminar un empleado con id (.*)$")
    public void actor_quiere_eliminar_un_empleado(String actor, String id) {
        theActorCalled(actor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl")))
                .attemptsTo(
                EliminarEmpleado.enServicio(id)
        );
    }

    @Entonces("^deberia obtener la confirmacion de la eliminacion$")
    public void deberia_obtener_confirmacion_eliminacion() {
        theActorInTheSpotlight().should(seeThat(VerificarEliminacionEmpleado.deLaRespuesta())
                .orComplainWith(CuerpoRespuestaIncorrecto.class, CUERPO_RESPUESTA_INCORRECTO));
    }
}
