package ru.gb.lesson;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactsTest extends BaseTest{
    @Test
    void contactsTest() {

        webDriver.findElement(By.xpath("(//a[contains(text(),'Контакты')])[2]")).click();

        WebElement contacts=webDriver.findElement(By.xpath("(//div[contains(@class, 'col-lg-5 col-md-5 col-sm-5 col-xs-12 contact_info')])"));
        List<WebElement> elements = contacts.findElements(new By.ByCssSelector("p"));
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(elements.get(0).getText()).isEqualTo("Телефон: 8-495-112-02-18");
        softAssertions.assertThat(elements.get(1).getText()).isEqualTo("Email: info@zoolakki.ru");
        softAssertions.assertAll();
    }
}
