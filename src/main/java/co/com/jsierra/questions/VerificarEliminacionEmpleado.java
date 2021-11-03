package co.com.jsierra.questions;

import co.com.jsierra.models.RsEliminarEmpleado;
import co.com.jsierra.utils.ConvertirObjeto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.jsierra.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerificarEliminacionEmpleado implements Question<Boolean> {

    public static VerificarEliminacionEmpleado deLaRespuesta() {
        return new VerificarEliminacionEmpleado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String id = actor.recall(VARIABLE_DATOS_EMPLEADO);
        RsEliminarEmpleado empleado = ConvertirObjeto.desdeJson(lastResponse().body().asString(), RsEliminarEmpleado.class);
        return empleado.getStatus().equalsIgnoreCase(STRING_STATUS) && empleado.getMessage().equalsIgnoreCase(STRING_MESSAGE_DELETE)
                && empleado.getData().equalsIgnoreCase(id);
    }

}
