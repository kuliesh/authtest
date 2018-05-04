package net.ukr.dev;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.AssertJUnit.assertEquals;

public class VerifiteTextOnMailTests extends BaseTests {
    final static Logger logger = Logger.getLogger(VerifiteTextOnMailTests.class);

    Random r = new Random();
    char c = (char)('а' + r.nextInt(32));

    @BeforeClass
    public void openPage() throws InterruptedException {
        open("http://accounts.dev.ukr.net/debug/drop_limits/s.kuliesh@dev.ukr.net");
        logger.info("Open page...");
        open("http://newfront.dev.ukr.net/desktop/login");
        $(By.cssSelector("#id-1")).sendKeys("s.kuliesh");
        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
        Thread.sleep(2000);
    }

    @Test
    public void test001_VerifiedTextForChangePersonalDateUa() throws InterruptedException {
        open("http://newfront.dev.ukr.net/desktop#security/personalData");
        //показує на якій сторінці драйвер знаходиться реально
        logger.info("url = " + url());

        //переключаємося на iframe
        By personalSettingsFrame = By.cssSelector("iframe.security__iframe");
        switchTo().frame($(personalSettingsFrame));

        //перевіряємо чи присутній елемент в DOM дереві
        $("button[class='personal-data__edit ui-button-inline']").should(Condition.visible);
        // клацаємо на кнопку
        $(By.cssSelector("button[class='personal-data__edit ui-button-inline']")).click();

        Thread.sleep(2000);

        $(By.cssSelector(".input-default__input.is-size-normal")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".popup-confirm__button.ui-button-default")).click();
        $(By.cssSelector("#personal-data-last-name")).clear();
        $(By.cssSelector("#personal-data-last-name")).sendKeys("Кулэш"+c);
        $(byText("Я новий власник скриньки")).click();
        $(By.cssSelector(".personal-data__submit.ui-button-default")).click();

        Thread.sleep(5000);
        open("http://newfront.dev.ukr.net/desktop#msglist/f0/p0");
        $(By.cssSelector(".msglist__row-address>a")).click();
        Thread.sleep(2000);
        assertEquals("Інформацію про те, коли і звідки було внесено ці зміни, збережено в Журналі безпеки.\n" +
                "\n" +
                "Ми також рекомендуємо переглянути Відкриті сесії, щоб дізнатися, коли, звідки і з яких пристроїв заходили у вашу скриньку останнім часом. Якщо якась сесія буде здаватися вам підозрілою, закрийте її.", $(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/section/div[2]/div[1]/span/span[2]/table/tbody/tr/td/table[2]/tbody/tr[3]/td[2]/p[2]/small")).getText());
        logger.info("Текст Журнал безпеки є ...");
        Thread.sleep(2000);
        $(By.cssSelector(".controls-link.remove")).click();
        Thread.sleep(2000);
        assertEquals("Ваша поштова адреса — s.kuliesh@dev.ukr.net", $(".msglist__empty>td").getText());
    }

    //Зміна локалізації
    @Test
    public void test002_VerifiedTextForChangePersonalDateRu() throws InterruptedException {
        open("http://newfront.dev.ukr.net/desktop#settings/interface");
        //
        $(By.xpath("//label/*[text()='Українська']")).click();
        $(By.xpath("//a[text()='Русский']")).click();
        $(By.cssSelector(".accept")).click();
        assertEquals("Настройки сохранены", $(".info.show").getText());
        Thread.sleep(2000);
        //
        open("http://newfront.dev.ukr.net/desktop#security/personalData");
        //показує на якій сторінці драйвер знаходиться реально
        logger.info("url = " + url());

        //переключаємося на iframe
        By personalSettingsFrame = By.cssSelector("iframe.security__iframe");
        switchTo().frame($(personalSettingsFrame));

        //перевіряємо чи присутній елемент в DOM дереві
        $("button[class='personal-data__edit ui-button-inline']").should(Condition.visible);
        // клацаємо на кнопку
        $(By.cssSelector("button[class='personal-data__edit ui-button-inline']")).click();

        Thread.sleep(2000);

        $(By.cssSelector(".input-default__input.is-size-normal")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".popup-confirm__button.ui-button-default")).click();
        $(By.cssSelector("#personal-data-last-name")).clear();
        $(By.cssSelector("#personal-data-last-name")).sendKeys("Кулэш"+c);
        $(byText("Я новый владелец ящика")).click();
        $(By.cssSelector(".personal-data__submit.ui-button-default")).click();

        Thread.sleep(5000);
        open("http://newfront.dev.ukr.net/desktop#msglist/f0/p0");
        $(By.cssSelector(".msglist__row-address>a")).click();
        Thread.sleep(2000);
        assertEquals("Информация о том, когда и откуда были внесены эти изменения, сохранена в Журнале безопасности.\n" +
                "\n" +
                "Мы также рекомендуем пересмотреть Открытые сессии, чтобы узнать, когда, откуда и с каких устройств заходили в ваш ящик в последнее время. Если какая-то сессия покажется вам подозрительной, закройте ее.", $(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/section/div[2]/div[1]/span/span[2]/table/tbody/tr/td/table[2]/tbody/tr[3]/td[2]/p[2]/small")).getText());
        logger.info("Текст Журнал безопасности є ...");
        $(By.cssSelector(".controls-link.remove")).click();
        assertEquals("Ваш почтовый адрес — s.kuliesh@dev.ukr.net", $(".msglist__empty>td").getText());
        Thread.sleep(2000);
    }

    @Test
    public void test003_VerifiedTextForChangePersonalDateEn() throws InterruptedException {
        open("http://newfront.dev.ukr.net/desktop#settings/interface");
        //
        $(By.xpath("//label/*[text()='Русский']")).click();
        $(By.xpath("//a[text()='English']")).click();
        $(By.cssSelector(".accept")).click();
        assertEquals("Settings saved", $(".info.show").getText());
        Thread.sleep(2000);
        //
        open("http://newfront.dev.ukr.net/desktop#security/personalData");
        //показує на якій сторінці драйвер знаходиться реально
        logger.info("url = " + url());

        //переключаємося на iframe
        By personalSettingsFrame = By.cssSelector("iframe.security__iframe");
        switchTo().frame($(personalSettingsFrame));

        //перевіряємо чи присутній елемент в DOM дереві
        $("button[class='personal-data__edit ui-button-inline']").should(Condition.visible);
        // клацаємо на кнопку
        $(By.cssSelector("button[class='personal-data__edit ui-button-inline']")).click();

        Thread.sleep(2000);

        $(By.cssSelector(".input-default__input.is-size-normal")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".popup-confirm__button.ui-button-default")).click();
        $(By.cssSelector("#personal-data-last-name")).clear();
        $(By.cssSelector("#personal-data-last-name")).sendKeys("Кулэш"+c);
        $(byText("I am a new account owner")).click();
        $(By.cssSelector(".personal-data__submit.ui-button-default")).click();

        Thread.sleep(5000);
        open("http://newfront.dev.ukr.net/desktop#msglist/f0/p0");
        $(By.cssSelector(".msglist__row-address>a")).click();
        Thread.sleep(2000);
        assertEquals("Please take a look at the Events Log in your account’s Security Log to find out where and when that happened.\n" +
                "\n" +
                "We also recommend you taking a look at the Open Sessions in your Security Settings for checking sign-in history – when, wherefrom and from which devices your account was used. If any of your sessions appears to be unfamiliar, sign out of it.", $(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/section/div[2]/div[1]/span/span[2]/table/tbody/tr/td/table[2]/tbody/tr[3]/td[2]/p[2]/small")).getText());
        logger.info("Текст Security Log є ...");
        $(By.cssSelector(".controls-link.remove")).click();
        assertEquals("Your email address — s.kuliesh@dev.ukr.net", $(".msglist__empty>td").getText());
        Thread.sleep(2000);


        //Переключення на український інтерфейс
        open("http://newfront.dev.ukr.net/desktop#settings/interface");
        //
        $(By.xpath("//label/*[text()='English']")).click();
        $(By.xpath("//a[text()='Українська']")).click();
        $(By.cssSelector(".accept")).click();
    }
}
