package co.com.jsierra.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crear_empleado.feature",
        glue = "co.com.jsierra.stepdefinitions",
        snippets = CAMELCASE
)
public class CrearEmpleado {
}
