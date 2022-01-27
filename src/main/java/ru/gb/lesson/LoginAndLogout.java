package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginAndLogout {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://www.zoolakki.ru/");
        webDriver.findElement(By.linkText("Вход")).click();
        By authFormLocator = By.xpath("//form[contains(@name,'form_auth')]");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("USER_LOGIN")).sendKeys("testgb");
        authForm.findElement(By.name("USER_PASSWORD")).sendKeys("123456");
        authForm.findElement(By.name("Login")).click();
        webDriver.findElement(By.linkText("Выйти")).click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Вход")));
        webDriver.quit();
    }
}
