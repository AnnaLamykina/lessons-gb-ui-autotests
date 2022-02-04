package ru.gb.lesson.lesson6.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactsPage extends BasePage {
    public ContactsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkContacts() {
        WebElement contacts = webDriver.findElement(By.xpath("(//div[contains(@class, 'col-lg-5 col-md-5 col-sm-5 col-xs-12 contact_info')])"));
        List<WebElement> elements = contacts.findElements(new By.ByCssSelector("p"));
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(elements.get(0).getText()).isEqualTo("Телефон: 8-495-112-02-18");
        softAssertions.assertThat(elements.get(1).getText()).isEqualTo("Email: info@zoolakki.ru");
        softAssertions.assertAll();
    }
}
