package co.com.jsierra.questions;

import co.com.jsierra.models.Empleado;
import co.com.jsierra.models.RsCrearEmpleado;
import co.com.jsierra.utils.ConvertirObjeto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.jsierra.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerificarCreacionEmpleado implements Question<Boolean> {

    public static VerificarCreacionEmpleado deLaRespuesta() {
        return new VerificarCreacionEmpleado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Empleado datosEmpleado = actor.recall(VARIABLE_DATOS_EMPLEADO);
        RsCrearEmpleado empleado = ConvertirObjeto.desdeJson(lastResponse().body().asString(), RsCrearEmpleado.class);
        return empleado.getStatus().equalsIgnoreCase(STRING_STATUS) && empleado.getMessage().equalsIgnoreCase(STRING_MESSAGE_CREATE)
                && datosEmpleado.equals(empleado.getData().getData());
    }

}
