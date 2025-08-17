package org.automation.appium.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import org.automation.appium.questions.productDetails.ProductDetailsMessages;
import org.automation.appium.screens.ProductsScreen;
import org.automation.appium.tasks.SearchFor;
import org.automation.appium.tasks.SelecItem;
import static org.hamcrest.Matchers.containsString;


public class ProductsExplorationStepDefinition {

    @When("navega hacia el producto {string} y se da click en el")
    public void navegaHaciaElProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchFor.item(nombreProducto),
                SelecItem.called(ProductsScreen.addLocator(nombreProducto))
        );
    }

    @Then("deberia ver el nombre del producto {string}")
    public void deberiaVerNombreProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductDetailsMessages.productName(nombreProducto), containsString(nombreProducto))
        );
    }

    @And("deberia ver que el precio del producto es {string}")
    public void deberiaVerPrecioProducto(String precio) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchFor.item(precio)
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductDetailsMessages.productPrice(precio), containsString(precio))
        );
    }

    @And("deberia ver que la descripcion del producto dice {string}")
    public void deberiaVerDescripcionProducto(String descripcion) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductDetailsMessages.productDescription(descripcion), containsString(descripcion))
        );
    }
}
