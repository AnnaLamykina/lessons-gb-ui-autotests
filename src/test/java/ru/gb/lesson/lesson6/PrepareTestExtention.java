package ru.gb.lesson.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.gb.lesson.lesson6.listener.ActionEventListener;

import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.step;

public class PrepareTestExtention {
    protected String login = "testgb";
    protected String password = "123456";
    public static final String URL = "https://www.zoolakki.ru/";
    protected EventFiringWebDriver webDriver;

    @AfterEach
    public void afterTestExecution(){
        step("Browser logs", () -> {
            for (LogEntry logEntry : webDriver.manage().logs().get(LogType.BROWSER)) {
                Allure.addAttachment("logs", logEntry.getMessage());
            }
        });
        webDriver.quit();
    }

    @BeforeEach
    public void beforeTestExecution() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        webDriver = new EventFiringWebDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
        webDriver.register(new ActionEventListener());
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}