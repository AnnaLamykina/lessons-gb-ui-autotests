package ru.gb.lesson;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchTest extends BaseTest{

    @ParameterizedTest
    @ValueSource(strings = {"собак", "кошек"})
    void Search(String productType) {
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).click();
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys(productType);
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys(Keys.ENTER);
        List<WebElement> catalogPopularNames = webDriver.findElements(By.xpath("(//div[contains(@class, 'catalog_popular_name')])"));
        assertThat(catalogPopularNames.get(0).getText()).contains(productType);
    }

}
