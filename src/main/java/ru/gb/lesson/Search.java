package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Search {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.zoolakki.ru/");
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).click();
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys("pro plan для кошек с индейкой");
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys(Keys.ENTER);
        webDriver.findElement(By.xpath("(//a[contains(text(),'2')])[5]")).click();
        webDriver.quit();
    }
}
