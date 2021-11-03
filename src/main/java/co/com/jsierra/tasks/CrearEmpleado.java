package co.com.jsierra.tasks;

import co.com.jsierra.models.Empleado;
import co.com.jsierra.models.RqCrearEmpleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.jsierra.utils.Constantes.PATH_EMPLOYEE_CREATE;
import static co.com.jsierra.utils.Constantes.VARIABLE_DATOS_EMPLEADO;

public class CrearEmpleado implements Task {
    private Empleado empleado;

    public CrearEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PATH_EMPLOYEE_CREATE)
                        .with(
                                request ->
                                        request
                                                .header("Content-Type", "application/json")
                                                .body(RqCrearEmpleado.builder()
                                                        .data(empleado)
                                                        .build())

                        )
        );
        actor.remember(VARIABLE_DATOS_EMPLEADO, empleado);
    }

    public static CrearEmpleado enServicio(Empleado empleado) {
        return Tasks.instrumented(CrearEmpleado.class, empleado);
    }
}
