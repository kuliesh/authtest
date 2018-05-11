package net.ukr.dev.TestingTheDesignOfTheRegistrationPageInterface;

import com.codeborne.selenide.Selectors;
import net.ukr.dev.BasesClassesForTests.BaseTests;
import net.ukr.dev.TimeLimiteTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

/**
 * **********************************************************************
 * @Project Name : AuthTestAutomation  - Selenium Framework.
 * @TestSet Name : VerifyNameElementsPageOfRegistrationEng
 * @Description : Verify Name Elements on Page Of Registration for Eng localization
 * @TestHeader : VerifyNameElementsPageOfRegistrationEng
 * @Date : 10-May-2018
 * @Author :  Sergii Kuliesh
 * **********************************************************************
 */

public class VerifyNameElementsPageOfRegistrationEng extends BaseTests {

    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://newfront.dev.ukr.net/desktop/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
        //Перевірка, що локалізація вибрана як "English"
        $(new Selectors.ByText("English")).click();
        assertEquals("English",$("button[class='header__lang-item is-current'] > span[class='header__lang-long-name']").getText());
        logger.info("Вибрана Українська мова.");
    }

    @Test
    public void test001_VerifyextWithoutElements(){

        //Первіряємо чи відображаються всі мови для вибору
        assertEquals("Українська", $(By.xpath("//button[1]")).getText());
        logger.info("Строка 'Українська' відображається");
        assertEquals("Русский", $(By.xpath("//button[2]")).getText());
        logger.info("Строка 'Русский' відображається");
        assertEquals("English", $(By.xpath("//button[3]")).getText());
        logger.info("Строка 'English' відображається");

        //Первіряємо чи відображаються всі загальні тексти
        assertEquals("Create Your @UKR.NET Mailbox", $(".header__title").getText());
        logger.info("Строка 'Create Your @UKR.NET Mailbox' відображається");
        assertEquals("Having created a mailbox, you can import your email from other email providers into it.", $(".import-info__content").getText());
        logger.info("Строка 'Having created a mailbox, you can import your email from other email providers into it.' відображається");
//        assertEquals("*Please, ensure that all fields are completed correctly", $(".annotation").getText());
//        logger.info("Строка '*Please, ensure that all fields are completed correctly' відображається");
        assertEquals("By clicking on \"Create mailbox\" button, I agree to the FREEMAIL (mail.ukr.net) Terms of Service.", $(".confirm-terms").getText());
        logger.info("Строка 'By clicking on \"Create mailbox\" button, I agree to the FREEMAIL (mail.ukr.net) Terms of Service.");
        assertEquals("24/7 SUPPORT SERVICE", $(".footer__support-title").getText());
        logger.info("Строка '24/7 SUPPORT SERVICE' відображається");

        assertEquals("support@ukr.net", $(By.xpath("//li[1]/a")).getText());
        logger.info("Строка 'support@ukr.net' відображається");
        assertEquals("(044) 235-85-55", $(By.xpath("//li[2]/a")).getText());
        logger.info("Строка '(044) 235-85-55' відображається");
        assertEquals("(050) 204-14-24", $(By.xpath("//li[3]/a")).getText());
        logger.info("Строка '204-14-24' відображається");
        assertEquals("(096) 718-55-52", $(By.xpath("//li[4]/a")).getText());
        logger.info("Строка '(096) 718-55-52' відображається");
    }

    @Test
    public void test002_VerifyTextForElements(){
        //Перевіряємо тексти для полей вводу
        //Поле логіну
        assertEquals("Think up your mailbox name", $(By.xpath("//section[1]/label")).getText());
        logger.info("Строка 'Think up your mailbox name' відображається");
        //Поле пароля
        assertEquals("Create a password", $(By.xpath("//section[2]/label[1]")).getText());
        logger.info("Строка 'Create a password' відображається");
        //Поле повтору пароля
        assertEquals("Confirm your password", $(By.xpath("//section[2]/label[2]")).getText());
        logger.info("Строка 'Confirm your password' відображається");
        //Поле вводу імені і призвища
        assertEquals("Your name", $(By.xpath("//section[3]/label[1]")).getText());
        logger.info("Строка 'Your name' відображається");
        //Дати народження
        assertEquals("Birthdate", $(By.xpath("//section[3]/label[2]")).getText());
        logger.info("Строка 'Birthdate' відображається");
        //Чекбокс для "Чоловік"
        assertEquals("Male", $(By.xpath("//div/div[1]/label[2]")).getText());
        logger.info("Строка 'Male' відображається");
        //Чекбокс для "Жінка"
        assertEquals("Female", $(By.xpath("//div/div[2]/label[2]")).getText());
        logger.info("Строка 'Female' відображається");
        //Поле вводу імені відправника
        assertEquals("Sender’s name", $(By.xpath("//section[4]/label")).getText());
        logger.info("Строка 'Sender’s name' відображається");
        //Поле вводу резеврної адреси пошти
        assertEquals("Optional recovery e-mail", $(By.xpath("//section[5]/label")).getText());
        logger.info("Строка 'Optional recovery e-mail' відображається");
        //Поле вводу мобільного телефону
        assertEquals("Mobile phone number", $(By.xpath("//section[6]/label")).getText());
        logger.info("Строка 'Mobile phone number' відображається");

        //Поле з повідомлення для активації
        assertEquals("You should activate your mailbox", $(By.xpath("//section[7]/button/b")).getText());
        logger.info("Строка 'You should activate your mailbox' відображається");
//        assertEquals("На вказаний номер мобільного телефону буде відправлено SMS з кодом активації", $(By.xpath("//section[7]/button/span[1]/text()")).getText());
//        logger.info("Строка 'На вказаний номер мобільного телефону  буде відправлено SMS з кодом активації' відображається");
        assertEquals("GET THE VERIFICATION CODE", $(By.xpath("//section[7]/button/span[2]")).getText());
        logger.info("Строка 'GET THE VERIFICATION CODE' відображається");

        //Чекбокс для імпорта
        assertEquals("Start importing my mail from other email providers", $(By.xpath("//label[2]/strong")).getText());
        logger.info("Строка 'Start importing my mail from other email providers' відображається");
        //Чекбокс для підтвердження ознайомлення з правилами
        assertEquals("I herein consent to my personal data processing in accordance with Privacy Policy which I have read and agreed to.", $(By.xpath("//label[2]/span")).getText());
        logger.info("Строка 'I herein consent to my personal data processing in accordance with Privacy Policy which I have read and agreed to.' відображається");
        //Кнопка реєстрації
        assertEquals("Create mailbox", $(".submit").getText());
        logger.info("Строка 'Create mailbox' відображається");
    }
    @Test //Перевірка тексту в полях для заповнення
    public void test003_VerifySuffikxForElements() {

        //текст в полі "Придумайте імя поштової скриньки"
        assertEquals("@dev.ukr.net", $(".form__login-suffix").getText());
        logger.info("Строка '@dev.ukr.net' відображається");
        //Імя та призвище
//        assertEquals("Ім'я", $(By.xpath("//input[@placeholder='']")).getText());
//        logger.info("Строка 'Ім'я' відображається");
        //Число місяь рік
        //
    }
}
