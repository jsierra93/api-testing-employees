package co.com.jsierra.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.jsierra.utils.Constantes.PATH_EMPLOYEE_DELETE;
import static co.com.jsierra.utils.Constantes.VARIABLE_DATOS_EMPLEADO;

public class EliminarEmpleado implements Task {
    private String id;

    public EliminarEmpleado(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(PATH_EMPLOYEE_DELETE)
                        .with(
                                request ->
                                        request
                                                .header("Content-Type", "application/json")
                                                .pathParam("id", id)
                        )
        );
        actor.remember(VARIABLE_DATOS_EMPLEADO, id);
    }

    public static EliminarEmpleado enServicio(String id) {
        return Tasks.instrumented(EliminarEmpleado.class, id);
    }
}
