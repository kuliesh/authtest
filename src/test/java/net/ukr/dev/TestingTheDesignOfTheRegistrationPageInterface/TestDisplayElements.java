package net.ukr.dev.TestingTheDesignOfTheRegistrationPageInterface;

import com.codeborne.selenide.Selectors;
import net.ukr.dev.BasesClassesForTests.BaseTests;
import net.ukr.dev.TimeLimiteTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestDisplayElements extends BaseTests {
    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("https://mail.ukr.net/desktop/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
    }

    @Test
    public void test001_VerifyElementsWithUkr(){
        logger.info("Відображення елементів на сторінці реєстрації при виборі української локалізації");
        assertTrue(($("#id-login")).isDisplayed());
        logger.info("Поле для вводу 'Придумайте ім'я поштової скриньки' відображається");
        assertTrue(($("#id-password")).isDisplayed());
        logger.info("Поле для вводу 'Придумайте пароль' відображається");
        assertTrue(($("#id-password-repeat")).isDisplayed());
        logger.info("Поле для вводу 'Введіть пароль повторно' відображається");
        assertTrue(($("#id-first-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я' відображається");
        assertTrue(($(By.xpath("//section[1]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'Прізвище' відображається");
        assertTrue(($("#id-birth-day")).isDisplayed());
        logger.info("Поле для вводу 'Числа' відображається");
        assertTrue(($(".input-select__target")).isDisplayed());
        logger.info("Поле для вводу 'місяць' відображається");
        assertTrue(($(By.xpath("//section[2]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'рік' відображається");
        assertTrue(($(By.xpath("//label[text()='Чоловік']"))).isDisplayed());
        logger.info("Радіобатон 'Чолвік' відображається");
        assertTrue(($(By.xpath("//label[text()='Жінка']"))).isDisplayed());
        logger.info("Радіобатон 'Жінка' відображається");
        assertTrue(($("#id-sender-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я відправника' відображається");
        assertTrue(($("#id-email")).isDisplayed());
        logger.info("Поле для вводу 'Резервний e-mail' відображається");
        assertTrue(($("#id-mobile")).isDisplayed());
        logger.info("Поле для вводу 'Мобільний телефон' відображається");
        assertTrue(($(".verifier__send.is-disabled")).isDisplayed());
        logger.info("Кнопка 'Отримати код' відображається");

        assertTrue(($(By.xpath("//section[8]/div/label[1]"))).isDisplayed());
        logger.info("Чекбокс для імпорту відображається");
        assertTrue(($(By.xpath("//section[8]/div/label[2]"))).isDisplayed());
        logger.info("Чекбокс для імпорту для погодження відображається");

        assertTrue(($(".submit")).isDisplayed());
        logger.info("Кнопка 'Зареєструвати скриньку' відображається");
    }

    @Test
    public void test002_VerifyElementsWithRu(){
        logger.info("Відображення елементів на сторінці реєстрації при виборі російської локалізації");
        logger.info("Переключаємося на російську локалізацію");
        $(new Selectors.ByText("Русский")).click();
        assertEquals("Создав ящик, вы сможете перенести в него свою почту из других почтовых сервисов.", $(".import-info__content").getText());
        /////////////////////////////////////
        assertTrue(($("#id-login")).isDisplayed());
        logger.info("Поле для вводу 'Придумайте ім'я поштової скриньки' відображається");
        assertTrue(($("#id-password")).isDisplayed());
        logger.info("Поле для вводу 'Придумайте пароль' відображається");
        assertTrue(($("#id-password-repeat")).isDisplayed());
        logger.info("Поле для вводу 'Введіть пароль повторно' відображається");
        assertTrue(($("#id-first-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я' відображається");
        assertTrue(($(By.xpath("//section[1]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'Прізвище' відображається");
        assertTrue(($("#id-birth-day")).isDisplayed());
        logger.info("Поле для вводу 'Числа' відображається");
        assertTrue(($(".input-select__target")).isDisplayed());
        logger.info("Поле для вводу 'місяць' відображається");
        assertTrue(($(By.xpath("//section[2]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'рік' відображається");
        assertTrue(($(By.xpath("//label[text()='Мужчина']"))).isDisplayed());
        logger.info("Радіобатон 'Чолвік' відображається");
        assertTrue(($(By.xpath("//label[text()='Женщина']"))).isDisplayed());
        logger.info("Радіобатон 'Жінка' відображається");
        assertTrue(($("#id-sender-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я відправника' відображається");
        assertTrue(($("#id-email")).isDisplayed());
        logger.info("Поле для вводу 'Резервний e-mail' відображається");
        assertTrue(($("#id-mobile")).isDisplayed());
        logger.info("Поле для вводу 'Мобільний телефон' відображається");
        assertTrue(($(".verifier__send.is-disabled")).isDisplayed());
        logger.info("Кнопка 'Отримати код' відображається");

        assertTrue(($(By.xpath("//section[8]/div/label[1]"))).isDisplayed());
        logger.info("Чекбокс для імпорту відображається");
        assertTrue(($(By.xpath("//section[8]/div/label[2]"))).isDisplayed());
        logger.info("Чекбокс для імпорту для погодження відображається");

        assertTrue(($(".submit")).isDisplayed());
        logger.info("Кнопка 'Зареєструвати скриньку' відображається");
        //////////////////////////////////////////
        logger.info("Переключаємося на українську локалізацію назад");
        $(new Selectors.ByText("Українська")).click();
    }

    @Test
    public void test003_VerifyElementsWithEng(){
        logger.info("Відображення елементів на сторінці реєстрації при виборі російської локалізації");
        logger.info("Переключаємося на англійську локалізацію");
        $(new Selectors.ByText("English")).click();
        assertEquals("Having created a mailbox, you can import your email from other email providers into it.", $(".import-info__content").getText());
        /////////////////////////////////////
        assertTrue(($("#id-login")).isDisplayed());
        logger.info("Поле для вводу 'Придумайте ім'я поштової скриньки' відображається");
        assertTrue(($("#id-password")).isDisplayed());
        logger.info("Поле для вводу 'Придумайте пароль' відображається");
        assertTrue(($("#id-password-repeat")).isDisplayed());
        logger.info("Поле для вводу 'Введіть пароль повторно' відображається");
        assertTrue(($("#id-first-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я' відображається");
        assertTrue(($(By.xpath("//section[1]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'Прізвище' відображається");
        assertTrue(($("#id-birth-day")).isDisplayed());
        logger.info("Поле для вводу 'Числа' відображається");
        assertTrue(($(".input-select__target")).isDisplayed());
        logger.info("Поле для вводу 'місяць' відображається");
        assertTrue(($(By.xpath("//section[2]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'рік' відображається");
        assertTrue(($(By.xpath("//label[text()='Male']"))).isDisplayed());
        logger.info("Радіобатон 'Чолвік' відображається");
        assertTrue(($(By.xpath("//label[text()='Female']"))).isDisplayed());
        logger.info("Радіобатон 'Жінка' відображається");
        assertTrue(($("#id-sender-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я відправника' відображається");
        assertTrue(($("#id-email")).isDisplayed());
        logger.info("Поле для вводу 'Резервний e-mail' відображається");
        assertTrue(($("#id-mobile")).isDisplayed());
        logger.info("Поле для вводу 'Мобільний телефон' відображається");
        assertTrue(($(".verifier__send.is-disabled")).isDisplayed());
        logger.info("Кнопка 'Отримати код' відображається");

        assertTrue(($(By.xpath("//section[8]/div/label[1]"))).isDisplayed());
        logger.info("Чекбокс для імпорту відображається");
        assertTrue(($(By.xpath("//section[8]/div/label[2]"))).isDisplayed());
        logger.info("Чекбокс для імпорту для погодження відображається");

        assertTrue(($(".submit")).isDisplayed());
        logger.info("Кнопка 'Зареєструвати скриньку' відображається");
        //////////////////////////////////////////
        logger.info("Переключаємося на українську локалізацію назад");
        $(new Selectors.ByText("Українська")).click();
    }


    @Test
    public void test003_VerifyElementsWithEngSoft(){
        SoftAssert softAssertion = new SoftAssert();
        logger.info("Відображення елементів на сторінці реєстрації при виборі російської локалізації");
        logger.info("Переключаємося на англійську локалізацію");
        $(new Selectors.ByText("English")).click();
        softAssertion.assertEquals("Having created a mailbox, you can import your email from other email providers into it.", $(".import-info__content").getText());
        /////////////////////////////////////
        softAssertion.assertTrue(($("#id-logi")).isDisplayed(),"#id-login is not displaed");
        logger.info("Поле для вводу 'Придумайте ім'я поштової скриньки' відображається");
        softAssertion.assertTrue(($("#id-password")).isDisplayed());
        logger.info("Поле для вводу 'Придумайте пароль' відображається");
        softAssertion.assertTrue(($("#id-password-repeat")).isDisplayed());
        logger.info("Поле для вводу 'Введіть пароль повторно' відображається");
        softAssertion.assertTrue(($("#id-first-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я' відображається");
        softAssertion.assertTrue(($(By.xpath("//section[1]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'Прізвище' відображається");
        softAssertion.assertTrue(($("#id-birth-day")).isDisplayed());
        logger.info("Поле для вводу 'Числа' відображається");
        softAssertion.assertTrue(($(".input-select__target")).isDisplayed());
        logger.info("Поле для вводу 'місяць' відображається");
        softAssertion.assertTrue(($(By.xpath("//section[2]/div/div[2]/input"))).isDisplayed());
        logger.info("Поле для вводу 'рік' відображається");
        softAssertion.assertTrue(($(By.xpath("//label[text()='Male']"))).isDisplayed());
        logger.info("Радіобатон 'Чолвік' відображається");
        softAssertion.assertTrue(($(By.xpath("//label[text()='Female']"))).isDisplayed());
        logger.info("Радіобатон 'Жінка' відображається");
        softAssertion.assertTrue(($("#id-sender-name")).isDisplayed());
        logger.info("Поле для вводу 'Ім'я відправника' відображається");
        softAssertion.assertTrue(($("#id-email")).isDisplayed());
        logger.info("Поле для вводу 'Резервний e-mail' відображається");
        softAssertion.assertTrue(($("#id-mobile")).isDisplayed());
        logger.info("Поле для вводу 'Мобільний телефон' відображається");
        softAssertion.assertTrue(($(".verifier__send.is-disabled")).isDisplayed());
        logger.info("Кнопка 'Отримати код' відображається");

        softAssertion.assertTrue(($(By.xpath("//section[8]/div/label[1]"))).isDisplayed());
        logger.info("Чекбокс для імпорту відображається");
        softAssertion.assertTrue(($(By.xpath("//section[8]/div/label[2]"))).isDisplayed());
        logger.info("Чекбокс для імпорту для погодження відображається");

        softAssertion.assertTrue(($(".submit")).isDisplayed());
        logger.info("Кнопка 'Зареєструвати скриньку' відображається");
        //////////////////////////////////////////
        logger.info("Переключаємося на українську локалізацію назад");
        $(new Selectors.ByText("Українська")).click();
        softAssertion.assertAll();
    }
}
