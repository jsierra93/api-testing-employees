package co.com.jsierra.questions;

import co.com.jsierra.models.RsListaEmpleados;
import co.com.jsierra.utils.ConvertirObjeto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.jsierra.utils.Constantes.STRING_MESSAGE_EMPLOYEES;
import static co.com.jsierra.utils.Constantes.STRING_STATUS;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerificarListaEmpleados implements Question<Boolean> {

    public static VerificarListaEmpleados deLaRespuesta() {
        return new VerificarListaEmpleados();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        RsListaEmpleados rsListaEmpleados = ConvertirObjeto.desdeJson(lastResponse().body().asString(), RsListaEmpleados.class);
        return rsListaEmpleados.getStatus().equalsIgnoreCase(STRING_STATUS) && rsListaEmpleados.getMessage().equalsIgnoreCase(STRING_MESSAGE_EMPLOYEES)
                && rsListaEmpleados.getData() != null;
    }

}
