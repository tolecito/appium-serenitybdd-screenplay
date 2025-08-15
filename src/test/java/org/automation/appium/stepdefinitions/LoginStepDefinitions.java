package org.automation.appium.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.es.Cuando;
//import io.cucumber.java.es.Dado;
//import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.automation.appium.questions.ValidationMessage.of;
import static org.automation.appium.screens.ProductsScreen.PRODUCTS_LABEL;
import static org.automation.appium.screens.LoginScreen.ERROR_LABEL_1;
import static org.automation.appium.screens.LoginScreen.ERROR_LABEL_2;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.automation.appium.tasks.LoginTask.withCredentials;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Given("que el usuario abre la app")
    public void queElUsuarioAbreLaApp() {
        // Implementa aquí la lógica para abrir la app
        OnStage.theActorCalled("usuario");
    }

    @When("el usuario inicia sesion con las credenciales {string} y {string}")
    public void elUsuarioSeLoguea(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                withCredentials(user, password)
        );
    }

    @Then("deberia ver el mensaje {string}")
    public void deberiaVerMensaje(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                the(PRODUCTS_LABEL, isVisible()).forNoMoreThan(20).seconds()
        );
        String mensajeObtenido = of(PRODUCTS_LABEL).answeredBy(OnStage.theActorInTheSpotlight());
        System.out.println("Mensaje obtenido: " + mensajeObtenido);
        OnStage.theActorInTheSpotlight().should(
                seeThat(of(PRODUCTS_LABEL), containsString(mensajeEsperado))
        );
    }

    @Then("deberia ver el mensaje de error {string} por usuario bloqueado")
    public void deberiaVerMensajeErrorUsuarioBloqueado(String mensajeEsperado) {
        // Validar que el mensaje sea visible
        /*OnStage.theActorInTheSpotlight().should(
                //seeThat(ValidationMessage.isVisible(), containsString(mensajeEsperado))
                seeThat(of(PRODUCTS_LABEL), containsString(mensajeEsperado))
        );*/
        OnStage.theActorInTheSpotlight().attemptsTo(
                the(ERROR_LABEL_1, isVisible()).forNoMoreThan(10).seconds()
        );
        String mensajeObtenido = of(ERROR_LABEL_1).answeredBy(OnStage.theActorInTheSpotlight());
        System.out.println("Mensaje obtenido: " + mensajeObtenido);
        OnStage.theActorInTheSpotlight().should(
                seeThat(of(ERROR_LABEL_1), containsString(mensajeEsperado))
        );
    }

    @Then("deberia ver el mensaje de error {string} por credenciales incorrectas")
    public void deberiaVerMensajeErrorCredencialesIncorrectas(String mensajeEsperado) {
        // Validar que el mensaje sea visible
        OnStage.theActorInTheSpotlight().should(
                //seeThat(ValidationMessage.isVisible(), containsString(mensajeEsperado))
                seeThat(of(ERROR_LABEL_2), containsString(mensajeEsperado))
        );
    }
}
