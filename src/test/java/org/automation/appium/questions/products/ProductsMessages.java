package org.automation.appium.questions.products;

import net.serenitybdd.screenplay.Question;
import org.automation.appium.questions.common.ValidationText;
import org.automation.appium.screens.ProductsScreen;

public class ProductsMessages {

    public static Question<String> screenTittle() {
        return ValidationText.of(ProductsScreen.PRODUCTS_LABEL);
    }
}
