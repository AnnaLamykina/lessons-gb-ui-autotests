package ru.gb.lesson.lesson6.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson.lesson6.PrepareTestExtention;
import ru.gb.lesson.lesson6.pages.LoginPage;
import ru.gb.lesson.lesson6.pages.MainPage;

public class LoginAndLogoutTest extends PrepareTestExtention {
    @Test
    @DisplayName("positive auth")
    @Severity(SeverityLevel.BLOCKER)
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
    @Severity(SeverityLevel.CRITICAL)
    void incorrectPasswordFailedAuthTest() {
        webDriver.get(URL);
        new LoginPage(webDriver)
                .getMainHeader()
                .goToLoginPage()
                .login(login, "password")
                .checkError("Неверный логин или пароль.");
    }
}
