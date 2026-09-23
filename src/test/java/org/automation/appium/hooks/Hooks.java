package org.automation.appium.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @After
    public void tearDown() {
        try {
            Runtime.getRuntime().exec(
                    "C:\\Users\\Usuario\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe " +
                            "shell pm clear com.swaglabsmobileapp"
            );

            System.out.println("Aplicación limpiada correctamente.");

        } catch (Exception e) {
            System.err.println(
                    "Error al limpiar aplicación: " + e.getMessage()
            );
        }
    }
}