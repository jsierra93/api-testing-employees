package co.com.jsierra.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.jsierra.utils.Constantes.PATH_EMPLOYEE_ID;

public class ConsultarEmpleadoId implements Task {
private String id;

    public ConsultarEmpleadoId(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(PATH_EMPLOYEE_ID)
                        .with(
                                request ->
                                        request
                                                .header("Content-Type", "application/json")
                                                .pathParam("id", id)

                        )
        );
    }

    public static ConsultarEmpleadoId enServicio(String id) {
        return Tasks.instrumented(ConsultarEmpleadoId.class, id);
    }
}
