package org.automation.appium.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.automation.appium.questions.login.LoginErrorMessages;
import org.automation.appium.questions.products.ProductsMessages;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.automation.appium.tasks.login.LoginTask.withCredentials;
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
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductsMessages.screenTittle(), containsString(mensajeEsperado))
        );
    }

    @Then("deberia ver el mensaje de error {string} por usuario bloqueado")
    public void deberiaVerMensajeErrorUsuarioBloqueado(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LoginErrorMessages.usuarioBloqueado(), containsString(mensajeEsperado))
        );
    }

    @Then("deberia ver el mensaje de error {string} por credenciales incorrectas")
    public void deberiaVerMensajeErrorCredencialesIncorrectas(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LoginErrorMessages.credencialesIncorrectas(), containsString(mensajeEsperado))
        );
    }
}
