package ru.gb.lesson.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PrepareTestExtention {
    protected String login = "testgb";
    protected String password = "123456";
    public static final String URL = "https://www.zoolakki.ru/";
    public static WebDriver webDriver;

    @AfterEach
    public void afterTestExecution(){
        webDriver.quit();
    }

    @BeforeEach
    public void beforeTestExecution() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}