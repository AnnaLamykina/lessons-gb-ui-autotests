package ru.gb.lesson.lesson6.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class FavoritesPage extends BasePage {
    public FavoritesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check, that product productName in favorites, and remove them")
    public void checkAndRemoveFavoriteProduct(String productName){
        WebElement catalogPopular1 = webDriver.findElement(By.xpath("(//div[contains(@class, 'catalog_popular 1')])"));
        assertThat(catalogPopular1.findElement(By.xpath("(//div[contains(@class, 'catalog_popular_name')])")).getText()).isEqualTo(productName);
        catalogPopular1.findElement(By.xpath("(//i[contains(@title, 'Удалить из избранного')])")).click();
    }
}
