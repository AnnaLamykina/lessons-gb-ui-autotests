package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkProductInSearchResult(String productType) {
        List<WebElement> catalogPopularNames = webDriver.findElements(By.xpath("(//div[contains(@class, 'catalog_popular_name')])"));
        assertThat(catalogPopularNames.get(0).getText()).contains(productType);
    }
}
