package ru.gb.lesson.lesson6.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.gb.lesson.lesson6.pages.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainHeader extends BaseView {



    @FindBy(linkText = "Вход")
    private WebElement loginButton;

    @FindBy(linkText = "Выйти")
    private WebElement logoutButton;

    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public ContactsPage goToContactPage() {
        webDriver.findElement(By.xpath("(//a[contains(text(),'Контакты')])[2]")).click();
        return new ContactsPage(webDriver);
    }

    public ProductsPage goToProductPage() {
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//a[text()='Кошки']")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//a[text()='Акции']")).click();
        return new ProductsPage(webDriver);
    }

    public LoginPage goToLoginPage() {
        loginButton.click();
        return new LoginPage(webDriver);
    }



    public SearchPage search(String productType) {
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).click();
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys(productType);
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys(Keys.ENTER);
        return new SearchPage(webDriver);
    }

    public void checkLoginAndLogout() {
        assertThat(logoutButton.getText()).isEqualTo("Выйти");
        logoutButton.click();
        assertThat(loginButton.getText()).isEqualTo("Вход");
    }

    public String favoriteProduct(){
        List<WebElement> catalogPopulars = webDriver.findElements(By.xpath("(//div[contains(@class, 'catalog_popular')])"));
        WebElement product=catalogPopulars.get(0).findElement(By.xpath("(//div[contains(@class, 'catalog_popular_name')])"));
        String productName=product.getText();
        catalogPopulars.get(0).findElement(By.xpath("(//i[contains(@title, 'Добавить в избранное')])")).click();
        webDriver.findElement(new By.ByCssSelector("#modalFav .close_window")).click();
        return productName;
    }

    public FavoritesPage goToFavorite(){
        webDriver.findElement(By.xpath("(//div[contains(@class, 'favoritesHeader hidden-md hidden-sm hidden-xs')])")).click();
        return new FavoritesPage(webDriver);
    }
}