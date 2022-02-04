package ru.gb.lesson;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
public class AddAndRemoveProductTest extends BaseTest {

    @Test
    void addAndRemoveProductTest() throws InterruptedException {
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//a[text()='Кошки']")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//a[text()='Акции']")).click();
        webDriver.findElement(By.xpath("(//a[contains(text(),'Купить')])[2]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Перейти в корзину')]")).click();
        WebElement productsCount = webDriver.findElement(By.xpath("//a[@class='basket-items-list-header-filter-item active']"));
        assertThat(productsCount.getText()).isEqualTo("В корзине 1 товар");
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//img[@class='basket-item-image']")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//span[@class='basket-item-actions-remove']")).click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.textToBePresentInElement(productsCount,"В корзине 0 товаров"));
        productsCount = webDriver.findElement(By.xpath("//a[@class='basket-items-list-header-filter-item active']"));
        assertThat(productsCount.getText()).isEqualTo("В корзине 0 товаров");
    }
}
