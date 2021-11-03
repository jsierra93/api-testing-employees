package co.com.jsierra.stepdefinitions;

import co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto;
import co.com.jsierra.exceptions.StatusCodeIncorrecto;
import co.com.jsierra.questions.VerificarListaEmpleados;
import co.com.jsierra.questions.VerificarCodigoRespuesta;
import co.com.jsierra.tasks.ConsultarListaEmpleados;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.jsierra.exceptions.CuerpoRespuestaIncorrecto.CUERPO_RESPUESTA_INCORRECTO;
import static co.com.jsierra.exceptions.StatusCodeIncorrecto.STATUS_CODE_INCORRECTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarEmpleadosStepDefinitions {


    @Cuando("^el (.*) consulta lista de empleados$")
    public void actor_consulta_lista_de_empleados(String actor) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarListaEmpleados.enServicio()
        );
    }

    @Entonces("^deberia obtener la informacion de todos los empleados$")
    public void deberia_obtener_informacion_todos_empleados() {
        theActorInTheSpotlight().should(seeThat(VerificarListaEmpleados.deLaRespuesta()).orComplainWith(CuerpoRespuestaIncorrecto.class, CUERPO_RESPUESTA_INCORRECTO));
    }
}
