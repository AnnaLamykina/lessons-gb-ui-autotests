package ru.gb.lesson.lesson6.pages.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.LoginPage;
import ru.gb.lesson.lesson6.pages.MainPage;

public class LoginAndLogoutTest extends PrepareTestExtention {
    @Test
    @DisplayName("positive auth")
    void successfulAuthTest() {
        webDriver.get(URL);
        new MainPage(webDriver)
                .getMainHeader()
                .goToLoginPage()
                .login(login, password)
                .getMainHeader()
                .checkLoginAndLogout();

    }

    @Test
    @DisplayName("negative auth")
    void incorrectPasswordFailedAuthTest() {
        webDriver.get(URL);
        new LoginPage(webDriver)
                .getMainHeader()
                .goToLoginPage()
                .login(login, "password")
                .checkError("Неверный логин или пароль.");
    }
}
