package ru.gb.lesson.lesson6.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.MainPage;

public class ContactsTest extends PrepareTestExtention {
    @Test
    @DisplayName("check contacts")
    @Severity(SeverityLevel.NORMAL)
    void successfulAuthTest() {
        webDriver.get(URL);
        new MainPage(webDriver)
                .getMainHeader()
                .goToContactPage()
                .checkContacts();
    }
}
