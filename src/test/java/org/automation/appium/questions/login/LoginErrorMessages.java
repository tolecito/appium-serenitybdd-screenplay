package org.automation.appium.questions.login;

import net.serenitybdd.screenplay.Question;
import org.automation.appium.questions.common.ValidationText;
import org.automation.appium.screens.LoginScreen;

public class LoginErrorMessages {

    public static Question<String> usuarioBloqueado() {
        return ValidationText.of(LoginScreen.ERROR_LABEL_1);
    }

    public static Question<String> credencialesIncorrectas() {
        return ValidationText.of(LoginScreen.ERROR_LABEL_2);
    }
}
