package ru.gb.lesson.lesson6.pages.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.MainPage;

public class AddAndRemoveProductTest extends PrepareTestExtention {
    @Test
    @DisplayName("Add item to cart and remove them")
    void putProductInCartTest() {

        webDriver.get(URL);

        new MainPage(webDriver)
                .getMainHeader()
                .goToProductPage()
                .putProductInCart()
                .goToCart()
                .checkProductsInCartAndRemoveThem();
    }
}
