package co.com.jsierra.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.jsierra.utils.Constantes.PATH_EMPLOYEES;

public class ConsultarListaEmpleados implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_EMPLOYEES)
                        .with(
                                request ->
                                        request
                                                .header("Content-Type", "application/json")

                        )
        );
    }

    public static ConsultarListaEmpleados enServicio() {
        return Tasks.instrumented(ConsultarListaEmpleados.class);
    }
}
