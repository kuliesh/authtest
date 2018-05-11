package net.ukr.dev.TestingTheDesignOfTheRegistrationPageInterface;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import net.ukr.dev.TimeLimiteTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * **********************************************************************
 * @Project Name : AuthTestAutomation  - Selenium Framework.
 * @TestSet Name : TestVerifyNameElementsPageOfRegistrationUkr
 * @Description : Verify Name Elements on Page Of Registration for Ukr localization
 * @TestHeader : TestVerifyNameElementsPageOfRegistrationUkr
 * @Date : 10-May-2018
 * @Author :  Sergii Kuliesh
 * **********************************************************************
 */

public class TestVerifyNameElementsPageOfRegistrationUkr extends BaseTests {

    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://newfront.dev.ukr.net/desktop/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
        //Перевірка, що локалізація вибрана як "Українська"
        assertEquals("Українська",$("button[class='header__lang-item is-current'] > span[class='header__lang-long-name']").getText());
        logger.info("Вибрана Українська мова.");
    }

    @Test
    public void test001_VerifyTextWithoutElements(){

        //Первіряємо чи відображаються всі мови для вибору
        assertEquals("Українська", $(By.xpath("//button[1]")).getText());
        logger.info("Строка 'Українська' відображається");
        assertEquals("Русский", $(By.xpath("//button[2]")).getText());
        logger.info("Строка 'Русский' відображається");
        assertEquals("English", $(By.xpath("//button[3]")).getText());
        assertTrue($(By.xpath("//button[3]")).isDisplayed());
        logger.info("Строка 'English' відображається");

        //Первіряємо чи відображаються всі загальні тексти
        assertEquals("Реєстрація поштової скриньки", $(".header__title").getText());
        logger.info("Строка 'Реєстрація поштової скриньки' відображається");
        assertEquals("Створивши скриньку, ви зможете перенести в неї свою пошту з інших поштових сервісів.", $(".import-info__content").getText());
        logger.info("Строка 'Створивши скриньку, ви зможете перенести в неї свою пошту з інших поштових сервісів.' відображається");
//        assertEquals("*Усі поля повинні містити коректні дані", $(".annotation").getText());
//        logger.info("Строка '*Усі поля повинні містити коректні дані' відображається");
        assertEquals("Натискаючи на кнопку «Зареєструвати скриньку», я приймаю умови Угоди про використання електронної пошти FREEMAIL (mail.ukr.net).", $(".confirm-terms").getText());
        logger.info("Строка 'Натискаючи на кнопку «Зареєструвати скриньку», я приймаю умови Угоди про використання електронної пошти FREEMAIL (mail.ukr.net).");
        assertEquals("ЦІЛОДОБОВА ПІДТРИМКА", $(".footer__support-title").getText());
        logger.info("Строка 'ЦІЛОДОБОВА ПІДТРИМКА' відображається");

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
        assertEquals("Придумайте ім'я поштової скриньки", $(By.xpath("//section[1]/label")).getText());
        logger.info("Строка 'Придумайте ім'я поштової скриньки' відображається");
        //Поле пароля
        assertEquals("Придумайте пароль", $(By.xpath("//section[2]/label[1]")).getText());
        logger.info("Строка 'Придумайте пароль' відображається");
        //Поле повтору пароля
        assertEquals("Введіть пароль повторно", $(By.xpath("//section[2]/label[2]")).getText());
        logger.info("Строка 'Введіть пароль повторно' відображається");
        //Поле вводу імені і призвища
        assertEquals("Як вас звати?", $(By.xpath("//section[3]/label[1]")).getText());
        logger.info("Строка 'Як вас звати?' відображається");
        //Дати народження
        assertEquals("Дата народження", $(By.xpath("//section[3]/label[2]")).getText());
        logger.info("Строка 'Дата народження' відображається");
        //Чекбокс для "Чоловік"
        assertEquals("Чоловік", $(By.xpath("//div/div[1]/label[2]")).getText());
        logger.info("Строка 'Чоловік' відображається");
        //Чекбокс для "Жінка"
        assertEquals("Жінка", $(By.xpath("//div/div[2]/label[2]")).getText());
        logger.info("Строка 'Жінка' відображається");
        //Поле вводу імені відправника
        assertEquals("Ім'я відправника", $(By.xpath("//section[4]/label")).getText());
        logger.info("Строка 'Ім'я відправника' відображається");
        //Поле вводу резеврної адреси пошти
        assertEquals("Резервний e-mail", $(By.xpath("//section[5]/label")).getText());
        logger.info("Строка 'Резервний e-mail' відображається");
        //Поле вводу мобільного телефону
        assertEquals("Мобільний телефон", $(By.xpath("//section[6]/label")).getText());
        logger.info("Строка 'Мобільний телефон' відображається");

        //Поле з повідомлення для активації
        assertEquals("Поштову скриньку необхідно активувати", $(By.xpath("//section[7]/button/b")).getText());
        logger.info("Строка 'Поштову скриньку необхідно активувати' відображається");
//        assertEquals("На вказаний номер мобільного телефону буде відправлено SMS з кодом активації", $(By.xpath("//section[7]/button/span[1]/text()")).getText());
//        logger.info("Строка 'На вказаний номер мобільного телефону  буде відправлено SMS з кодом активації' відображається");
        assertEquals("ОТРИМАТИ КОД", $(By.xpath("//section[7]/button/span[2]")).getText());
        logger.info("Строка 'ОТРИМАТИ КОД' відображається");

        //Чекбокс для імпорта
        assertEquals("Розпочати імпорт пошти з інших поштових сервісів", $(By.xpath("//label[2]/strong")).getText());
        logger.info("Строка 'Розпочати імпорт пошти з інших поштових сервісів' відображається");
        //Чекбокс для підтвердження ознайомлення з правилами
        assertEquals("Я надаю згоду на обробку персональних даних відповідно до Угоди про конфіденційність і приймаю її умови.", $(By.xpath("//label[2]/span")).getText());
        logger.info("Строка 'Я надаю згоду на обробку персональних даних відповідно до Угоди про конфіденційність і приймаю її умови.' відображається");
        //Кнопка реєстрації
        assertEquals("Зареєструвати скриньку", $(".submit").getText());
        logger.info("Строка 'Зареєструвати скриньку' відображається");
    }

    @Test //Перевірка тексту в полях для заповнення
    public void test003_VerifySuffikxForElements(){

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
