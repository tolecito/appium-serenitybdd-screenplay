package org.automation.appium.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import org.automation.appium.questions.productDetails.ProductDetailsMessages;
import org.automation.appium.tasks.common.SearchFor;
import org.automation.appium.tasks.products.SelectProduct;

import static org.hamcrest.Matchers.containsString;


public class ProductsExplorationStepDefinition {

    @When("navega hacia el producto {string} y se da click en el")
    public void navegaHaciaElProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchFor.item(nombreProducto),
                SelectProduct.called(nombreProducto)
        );
    }

    @Then("deberia ver el nombre del producto {string}")
    public void deberiaVerNombreProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductDetailsMessages.productName(nombreProducto), containsString(nombreProducto))
        );
    }

    @And("deberia ver que el precio del producto es {string}")
    public void deberiaVerPrecioProducto(String precioProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchFor.item(precioProducto)
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductDetailsMessages.productPrice(precioProducto), containsString(precioProducto))
        );
    }

    @And("deberia ver que la descripcion del producto dice {string}")
    public void deberiaVerDescripcionProducto(String descripcionProducto) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductDetailsMessages.productDescription(descripcionProducto), containsString(descripcionProducto))
        );
    }
}
