package org.automation.appium.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.automation.appium.questions.ValidationMessage.of;
import static org.automation.appium.screens.ProductsScreen.PRODUCTS_LABEL;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.automation.appium.tasks.LoginTask.withCredentials;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Dado("que el usuario abre la app")
    public void queElUsuarioAbreLaApp() {
        // Implementa aquí la lógica para abrir la app
        OnStage.theActorCalled("usuario");
    }

    @Cuando("el usuario se loguea con {string} y {string}")
    public void elUsuarioSeLoguea(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                withCredentials(user, password)
        );
    }

    @Entonces("debería ver el mensaje {string}")
    public void deberiaVerMensaje(String mensajeEsperado) {
        // Validar que el mensaje sea visible
        /*OnStage.theActorInTheSpotlight().should(
                //seeThat(ValidationMessage.isVisible(), containsString(mensajeEsperado))
                seeThat(of(PRODUCTS_LABEL), containsString(mensajeEsperado))
        );*/
        OnStage.theActorInTheSpotlight().attemptsTo(
                the(PRODUCTS_LABEL, isVisible()).forNoMoreThan(20).seconds()
        );
        String mensajeObtenido = of(PRODUCTS_LABEL).answeredBy(OnStage.theActorInTheSpotlight());
        System.out.println("Mensaje obtenido: " + mensajeObtenido);
        OnStage.theActorInTheSpotlight().should(
                seeThat(of(PRODUCTS_LABEL), containsString(mensajeEsperado))
        );
    }
}
