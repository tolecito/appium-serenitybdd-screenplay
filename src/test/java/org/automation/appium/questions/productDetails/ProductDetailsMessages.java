package org.automation.appium.questions.productDetails;

import net.serenitybdd.screenplay.Question;
import org.automation.appium.questions.common.ValidationText;
import org.automation.appium.screens.ProductDetailsScreen;

public class ProductDetailsMessages {

    public static Question<String> productName(String text) {
        return ValidationText.of(ProductDetailsScreen.addLocator(text));
    }

    public static Question<String> productPrice(String text) {
        return ValidationText.of(ProductDetailsScreen.addLocator(text));
    }

    public static Question<String> productDescription(String text) {
        return ValidationText.of(ProductDetailsScreen.addLocator(text));
    }

}
