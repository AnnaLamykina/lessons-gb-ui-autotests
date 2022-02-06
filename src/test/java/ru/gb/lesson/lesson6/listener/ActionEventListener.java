package ru.gb.lesson.lesson6.listener;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static io.qameta.allure.Allure.step;


public class ActionEventListener extends AbstractWebDriverEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ActionEventListener.class);

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        String actionName = "Click on element " + element.getText();
        logger.info(actionName);
        step(actionName);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        String actionName = "Success!";
        logger.info(actionName);
        step(actionName);

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        String actionName = "Enter text '" + Arrays.toString(keysToSend) + "' into element " + element.getAttribute("id");
        logger.info(actionName);
        step(actionName);

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        String actionName = "Success!";
        logger.info(actionName);
        step(actionName);
    }


    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
}