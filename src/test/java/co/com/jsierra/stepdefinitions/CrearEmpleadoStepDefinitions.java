package co.com.jsierra.stepdefinitions;

import co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto;
import co.com.jsierra.models.Empleado;
import co.com.jsierra.questions.VerificarCreacionEmpleado;
import co.com.jsierra.questions.VerificarEmpleadoId;
import co.com.jsierra.tasks.ConsultarEmpleadoId;
import co.com.jsierra.tasks.CrearEmpleado;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;

import static co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto.CUERPO_RESPUESTA_INCORRECTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearEmpleadoStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Cuando("^el (.*) quiere crear un empleado$")
    public void actor_quiere_crear_un_empleado(String actor, List<Empleado> datosEmpleado) {
        theActorCalled(actor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl")))
                .attemptsTo(
                CrearEmpleado.enServicio(datosEmpleado.get(0))
        );
    }

    @Entonces("^deberia obtener la confirmacion del registro$")
    public void deberia_obtener_informacion_empleado() {
        theActorInTheSpotlight().should(seeThat(VerificarCreacionEmpleado.deLaRespuesta())
                .orComplainWith(CuerpoRespuestaIncorrecto.class, CUERPO_RESPUESTA_INCORRECTO));
    }
}
