package ru.gb.lesson.lesson6.pages.blocks;

import io.qameta.allure.Step;
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

    @Step("Go to contacts page")
    public ContactsPage goToContactPage() {
        webDriver.findElement(By.xpath("(//a[contains(text(),'Контакты')])[2]")).click();
        return new ContactsPage(webDriver);
    }

    @Step("Go to products page")
    public ProductsPage goToProductPage() {
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//a[text()='Кошки']")))
                .build()
                .perform();
        webDriver.findElement(By.xpath("//a[text()='Акции']")).click();
        return new ProductsPage(webDriver);
    }

    @Step("Go to login page")
    public LoginPage goToLoginPage() {
        loginButton.click();
        return new LoginPage(webDriver);
    }

    @Step("Searhc product")
    public SearchPage search(String productType) {
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).click();
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys(productType);
        webDriver.findElement(By.xpath("(//input[@id='title-search-input'])[2]")).sendKeys(Keys.ENTER);
        return new SearchPage(webDriver);
    }

    @Step("Click logout and, check that login appears")
    public void checkLoginAndLogout() {
        assertThat(logoutButton.getText()).isEqualTo("Выйти");
        logoutButton.click();
        assertThat(loginButton.getText()).isEqualTo("Вход");
    }

    @Step("Favorite product")
    public String favoriteProduct(){
        List<WebElement> catalogPopulars = webDriver.findElements(By.xpath("(//div[contains(@class, 'catalog_popular')])"));
        WebElement product=catalogPopulars.get(0).findElement(By.xpath("(//div[contains(@class, 'catalog_popular_name')])"));
        String productName=product.getText();
        catalogPopulars.get(0).findElement(By.xpath("(//i[contains(@title, 'Добавить в избранное')])")).click();
        webDriver.findElement(new By.ByCssSelector("#modalFav .close_window")).click();
        return productName;
    }

    @Step("Go to favorites page")
    public FavoritesPage goToFavorite(){
        webDriver.findElement(By.xpath("(//div[contains(@class, 'favoritesHeader hidden-md hidden-sm hidden-xs')])")).click();
        return new FavoritesPage(webDriver);
    }
}