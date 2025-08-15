package org.automation.appium.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.automation.appium.questions.ValidationMessage.of;

import org.automation.appium.screens.ProductsScreen;

import static org.automation.appium.screens.ProductsScreen.PRODUCTS_LABEL;
import static org.automation.appium.tasks.ScrollTask.scrollAndClick;
import static org.hamcrest.Matchers.containsString;


public class DetalleProductoStepDefinition {

    @When("navega hacia el producto {string} y se da click en el")
    public void navegaHaciaElProducto(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                scrollAndClick(nombreProducto,ProductsScreen.asignarLocalizador(nombreProducto))
        );
    }

    @Then("deberia ver el nombre del producto {string}")
    public void deberiaVerProducto(String nombreProducto) {
        String mensajeObtenido = of(PRODUCTS_LABEL).answeredBy(OnStage.theActorInTheSpotlight());
        System.out.println("Mensaje obtenido: " + mensajeObtenido);
        OnStage.theActorInTheSpotlight().should(
                seeThat(of(PRODUCTS_LABEL), containsString(mensajeEsperado))
        );
    }

    @And("deberia ver que el precio del producto es {string}")
    public void deberiaVerPrecioProducto(String precioProducto) {
        System.out.println("Precio del producto: " + ProductsScreen.asignarLocalizador(precioProducto));

        OnStage.theActorInTheSpotlight().attemptsTo(
                //the(PRICE_4, isVisible()).forNoMoreThan(20).seconds()
                //scrollAndClick(nombreProducto,ProductsScreen.asignarLocalizador(nombreProducto)),
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(of(PRICE_4), containsString(precioProducto))
        );
    }
}
