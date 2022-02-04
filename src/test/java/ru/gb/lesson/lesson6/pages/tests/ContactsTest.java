package ru.gb.lesson.lesson6.pages.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.MainPage;

public class ContactsTest extends PrepareTestExtention {
    @Test
    @DisplayName("check contatcs")
    void successfulAuthTest() {
        webDriver.get(URL);
        new MainPage(webDriver)
                .getMainHeader()
                .goToContactPage()
                .checkContacts();
    }
}
