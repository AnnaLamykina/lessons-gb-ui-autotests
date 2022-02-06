package ru.gb.lesson.lesson6.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.MainPage;


public class SearchTest extends PrepareTestExtention {
    @ValueSource(strings = {"собак", "кошек"})
    @ParameterizedTest(name = "search {0}")
    @Severity(SeverityLevel.TRIVIAL)
    void Search(String productType) {
        webDriver.get(URL);
        new MainPage(webDriver)
                .getMainHeader()
                .search(productType)
                .checkProductInSearchResult(productType);
    }
}
