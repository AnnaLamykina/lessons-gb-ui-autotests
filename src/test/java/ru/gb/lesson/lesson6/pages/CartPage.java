package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkProductsInCartAndRemoveThem() {
        WebElement productsCount = webDriver.findElement(By.xpath("//a[@class='basket-items-list-header-filter-item active']"));
        assertThat(productsCount.getText()).isEqualTo("В корзине 1 товар");
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//img[@class='basket-item-image']")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//span[@class='basket-item-actions-remove']")).click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.textToBePresentInElement(productsCount, "В корзине 0 товаров"));
        productsCount = webDriver.findElement(By.xpath("//a[@class='basket-items-list-header-filter-item active']"));
        assertThat(productsCount.getText()).isEqualTo("В корзине 0 товаров");
    }
}