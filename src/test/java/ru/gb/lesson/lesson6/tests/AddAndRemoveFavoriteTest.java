package ru.gb.lesson.lesson6.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.MainPage;


public class AddAndRemoveFavoriteTest extends PrepareTestExtention {
    @Test
    @DisplayName("Add object to favorite, check them and remove")
    @Severity(SeverityLevel.MINOR)
    void favorite() {
        webDriver.get(URL);
        String name= new MainPage(webDriver)
                .getMainHeader()
                .favoriteProduct();
        Allure.parameter("Product name", name);
        new MainPage(webDriver)
                .getMainHeader()
                .goToFavorite()
                .checkAndRemoveFavoriteProduct(name);
    }
}
