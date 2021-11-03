package co.com.jsierra.questions;

import co.com.jsierra.models.ListaEmpleados;
import co.com.jsierra.utils.ConvertirObjeto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import static co.com.jsierra.utils.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerificarListaEmpleados implements Question<Boolean> {

    public static VerificarListaEmpleados deLaRespuesta() {
        return new VerificarListaEmpleados();
    }

    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {
       // ListaEmpleados listaEmpleados = lastResponse().body().as(ListaEmpleados.class);
       // validarSchema(lastResponse().jsonPath().prettyPrint());
        ListaEmpleados listaEmpleados = ConvertirObjeto.desdeJson(lastResponse().body().asString(), ListaEmpleados.class);
        return listaEmpleados.getStatus().equalsIgnoreCase(STRING_STATUS) && listaEmpleados.getMessage().equalsIgnoreCase(STRING_MESSAGE_EMPLOYEES)
                && listaEmpleados.getData() != null ;
    }

    public static void validarSchema(String jsonResponse) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        final File schemaJson = new File("/Users/joasierr/Downloads/api-testing-employees/src/test/resources/schemas/employees.json");
        InputStream schemaStream = new FileInputStream(schemaJson);
        //System.out.println(new String(schemaStream.readAllBytes()));
        JsonNode json = objectMapper.readTree(jsonResponse);
        JsonSchema schema = schemaFactory.getSchema(new String(schemaStream.readAllBytes()));
        Set<ValidationMessage> validationResult = schema.validate(json);
        if (validationResult.isEmpty()) {
            System.out.println("There is no validation errors");
        } else {
            validationResult.forEach(vm -> System.out.println(vm.getMessage()));
        }
    }
}
