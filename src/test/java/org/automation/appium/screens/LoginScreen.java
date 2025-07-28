package org.automation.appium.screens;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class LoginScreen {
    public static final Target USERNAME_FIELD = Target.the("Campo User")
            .located(AppiumBy.accessibilityId("test-Username"));

    public static final Target PASSWORD_FIELD = Target.the("Campo Password")
            .located(AppiumBy.accessibilityId("test-Password"));

    public static final Target LOGIN_BUTTON = Target.the("Boton Login")
            .located(AppiumBy.accessibilityId("test-LOGIN"));

    public static final Target ERROR_LABEL_1 = Target.the("Texto Error Login")
            .located(AppiumBy.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]"));

    public static final Target ERROR_LABEL_2 = Target.the("Texto Error Login")
            .located(AppiumBy.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));
    /*public static final Target WELCOME_MESSAGE = Target.the("mensaje de bienvenida")
            .located(By.id("com.tuapp:id/welcome_text"));*/
}

