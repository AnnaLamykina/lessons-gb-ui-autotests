package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage {
    private By errorFont = By.xpath("//font[@class='errortext']");
    private By userNameInput = By.name("USER_LOGIN");
    private By passwordInput = By.name("USER_PASSWORD");
    private By loginButton = By.name("Login");
    private By authFormLocator = By.xpath("//form[contains(@name,'form_auth')]");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage login(String login, String password) {
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(userNameInput).sendKeys(login);
        authForm.findElement(passwordInput).sendKeys(password);
        authForm.findElement(loginButton).click();
        return this;
    }

    public void checkError(String errorText) {
        assertThat(webDriver.findElement(errorFont).getText())
                .isEqualTo(errorText);
    }

}