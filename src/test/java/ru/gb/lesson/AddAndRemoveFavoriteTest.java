package ru.gb.lesson;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AddAndRemoveFavoriteTest extends BaseTest {
    @Test
    void favorite() {
        List<WebElement> catalogPopulars = webDriver.findElements(By.xpath("(//div[contains(@class, 'catalog_popular')])"));
        WebElement product=catalogPopulars.get(0).findElement(By.xpath("(//div[contains(@class, 'catalog_popular_name')])"));
        String productName=product.getText();
        WebElement favorite=catalogPopulars.get(0).findElement(By.xpath("(//i[contains(@title, 'Добавить в избранное')])"));
        favorite.click();
        webDriver.findElement(By.xpath("(//a[contains(text(),'Перейти в избранное')])")).click();
        WebElement catalogPopular1 = webDriver.findElement(By.xpath("(//div[contains(@class, 'catalog_popular 1')])"));
        assertThat(catalogPopular1.findElement(By.xpath("(//div[contains(@class, 'catalog_popular_name')])")).getText()).isEqualTo(productName);
        catalogPopular1.findElement(By.xpath("(//i[contains(@title, 'Удалить из избранного')])")).click();
    }
}
