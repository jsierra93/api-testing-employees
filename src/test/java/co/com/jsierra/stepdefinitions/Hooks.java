package co.com.jsierra.stepdefinitions;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("actor")
                .whoCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl")));
    }
}
