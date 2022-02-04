package ru.gb.lesson.lesson6.pages.tests;

import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.MainPage;


public class AddAndRemoveFavoriteTest extends PrepareTestExtention {
    @Test
    void favorite() {
        webDriver.get(URL);
        String name= new MainPage(webDriver)
                .getMainHeader()
                .favoriteProduct();
        new MainPage(webDriver)
                .getMainHeader()
                .goToFavorite()
                .checkAndRemoveFavoriteProduct(name);
    }
}
