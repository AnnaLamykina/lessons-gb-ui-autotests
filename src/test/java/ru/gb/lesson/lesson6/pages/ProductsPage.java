package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductsPage putProductInCart() {
        webDriver.findElement(By.xpath("(//a[contains(text(),'Купить')])[2]")).click();
        return this;
    }

    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Перейти в корзину')]")).click();
        return new CartPage(webDriver);
    }
}