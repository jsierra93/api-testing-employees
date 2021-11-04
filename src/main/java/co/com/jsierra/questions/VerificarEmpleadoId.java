package co.com.jsierra.questions;

import co.com.jsierra.models.RsEmpleadoId;
import co.com.jsierra.utils.ConvertirObjeto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.jsierra.utils.Constantes.STRING_MESSAGE_EMPLOYEE_ID;
import static co.com.jsierra.utils.Constantes.STRING_STATUS;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerificarEmpleadoId implements Question<Boolean> {

    public static VerificarEmpleadoId deLaRespuesta() {
        return new VerificarEmpleadoId();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        RsEmpleadoId empleado = ConvertirObjeto.desdeJson(lastResponse().body().asString(), RsEmpleadoId.class);
        return empleado.getStatus().equalsIgnoreCase(STRING_STATUS) && empleado.getMessage().equalsIgnoreCase(STRING_MESSAGE_EMPLOYEE_ID)
                && empleado.getData().getId() == 1 ;
    }

}
