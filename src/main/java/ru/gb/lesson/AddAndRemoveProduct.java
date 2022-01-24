package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AddAndRemoveProduct {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.zoolakki.ru/");
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//a[text()='Кошки']")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//a[text()='Акции']")).click();
        webDriver.findElement(By.xpath("(//a[contains(text(),'Купить')])[2]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Перейти в корзину')]")).click();
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//img[@class='basket-item-image']")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//span[@class='basket-item-actions-remove']")).click();
        webDriver.quit();
    }
}
