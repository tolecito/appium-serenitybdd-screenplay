package org.automation.appium.hooks;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.automation.appium.AppiumDriverFactory;
import net.serenitybdd.core.Serenity;


public class Hooks {
    @Before
    public void setTheStage() {
        System.out.println("Inicializando el escenario de Screenplay...");
        OnStage.setTheStage(new OnlineCast());
        //OnStage.theActorCalled("John Wick");
        try {
            AppiumDriver driver = AppiumDriverFactory.getDriver();

            // Registrar el driver como habilidad para el actor principal
            OnStage.theActorCalled("usuario").can(BrowseTheWeb.with(driver));

            System.out.println("Driver configurado para el actor.");
        } catch (Exception e) {
            System.err.println("Error al configurar AppiumDriver: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        // Limpiar caché de la aplicación (ejemplo para Android)
        try {
            Runtime.getRuntime().exec("adb shell pm clear com.swaglabsmobileapp");
            System.out.println("Caché limpiado y recursos liberados");
        } catch (Exception e) {
            System.err.println("Error al limpiar caché: " + e.getMessage());
        }
    }
}
