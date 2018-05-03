package net.ukr.dev;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class VerifiteTextOnMailTests extends BaseTests {
    final static Logger logger = Logger.getLogger(VerifiteTextOnMailTests.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("http://accounts.dev.ukr.net/registration");
        Thread.sleep(2000);
    }

    @Test
    public void test001_VerifiedTextForChangePersonalDate() throws InterruptedException {
    open("http://newfront.dev.ukr.net/desktop/login");
    $(By.cssSelector("#id-1")).sendKeys("s.kuliesh");
    $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
    $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
    Thread.sleep(2000);

    open("http://newfront.dev.ukr.net/desktop#security/personalData");
    $(byClassName("personal-data__edit ui-button-inline")).click();
    Thread.sleep(2000);

        $(By.cssSelector(".input-default__input.is-size-normal")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".popup-confirm__button.ui-button-default")).click();
        $(By.cssSelector("#personal-data-last-name")).clear();
        $(By.cssSelector("#personal-data-last-name")).sendKeys("Кулэш");
        $(byText("Я новий власник скриньки")).click();
        $(By.cssSelector(".personal-data__submit.ui-button-default")).click();

        Thread.sleep(2000);
        open("http://newfront.dev.ukr.net/desktop#msglist/f0/p0");
        $(By.cssSelector(".msglist__row-address>a")).click();
        Thread.sleep(2000);
        assertEquals("Інформацію про те, коли і звідки було внесено ці зміни, збережено в Журналі подій.", $(".xfm_98171760>span>table>tbody>tr>td>table>tbody>tr>td>p").getText());
        logger.info("Текст Журнал безпеки є ...");
        Thread.sleep(2000);
        $(By.cssSelector(".controls-link.remove")).click();
        Thread.sleep(2000);
        assertEquals("Ваша поштова адреса — s.kuliesh@dev.ukr.net", $(".msglist__empty>td").getText());
        Thread.sleep(2000);
    }

}
