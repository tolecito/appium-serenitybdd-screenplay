package org.automation.appium.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {
    @Before
    public void setTheStage() {
        System.out.println("Inicializando el escenario de Screenplay...");
        OnStage.setTheStage(new OnlineCast());
        //OnStage.theActorCalled("John Wick");
    }

    @After
    public void tearDown() {
        // Limpiar caché de la aplicación (ejemplo para Android)
        try {
            Runtime.getRuntime().exec("adb shell pm clear <paquete.de.la.app>");
            System.out.println("Caché limpiado y recursos liberados");
        } catch (Exception e) {
            System.err.println("Error al limpiar caché: " + e.getMessage());
        }
    }
}
