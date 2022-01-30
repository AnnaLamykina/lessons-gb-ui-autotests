package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginAndLogout extends BaseTest{
    @Test
    void loginLogout() {
        WebElement Enter=webDriver.findElement(By.linkText("Вход"));
        assertThat(Enter.getText()).isEqualTo("Вход");
        Enter.click();
        By authFormLocator = By.xpath("//form[contains(@name,'form_auth')]");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("USER_LOGIN")).sendKeys("testgb");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("123456");
        authForm.findElement(By.name("Login")).click();
        WebElement Exit=webDriver.findElement(By.linkText("Выйти"));
        assertThat(Exit.getText()).isEqualTo("Выйти");
        Exit.click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Вход")));
        Enter=webDriver.findElement(By.linkText("Вход"));
        assertThat(Enter.getText()).isEqualTo("Вход");
    }
}
