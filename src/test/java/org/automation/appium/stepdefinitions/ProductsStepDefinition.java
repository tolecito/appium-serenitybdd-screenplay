package org.automation.appium.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static org.automation.appium.questions.ValidationMessage.of;

import org.automation.appium.interactions.ScrollToText;
import org.automation.appium.screens.ProductsScreen;

import static org.hamcrest.Matchers.containsString;

import static org.automation.appium.screens.ProductsScreen.PRODUCT_5;
import static org.automation.appium.screens.ProductsScreen.PRICE_5;
import static org.automation.appium.screens.ProductsScreen.SCROLL_CONTAINER;
import org.automation.appium.interactions.TapElement;


public class ProductsStepDefinition {

    @When("navega hacia el producto {string}")
    public void navegaHaciaElProducto(String nombreProducto) {
        System.out.println("Navegando hacia el producto: " + ProductsScreen.asignarLocalizador(nombreProducto));

        OnStage.theActorInTheSpotlight().attemptsTo(
                TapElement.on(SCROLL_CONTAINER)
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                //ScrollToText.named(PRODUCT_5)
                ScrollToText.untilVisible(nombreProducto)
        );
    }

    @Then("deberia ver que el precio del producto es {string}")
    public void deberiaVerPrecioProducto(String precioProducto) {
        System.out.println("Precio del producto: " + ProductsScreen.asignarLocalizador(precioProducto));

        OnStage.theActorInTheSpotlight().attemptsTo(
                the(PRICE_5, isVisible()).forNoMoreThan(20).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(of(PRICE_5), containsString(precioProducto))
        );
    }
}
