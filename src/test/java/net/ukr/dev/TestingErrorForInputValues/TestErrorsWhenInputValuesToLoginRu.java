package net.ukr.dev.TestingErrorForInputValues;

import com.codeborne.selenide.Selectors;
import net.ukr.dev.BasesClassesForTests.BaseTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.beans.IntrospectionException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class TestErrorsWhenInputValuesToLoginRu extends BaseTests {
    final static Logger logger = Logger.getLogger(TestErrorsWhenInputValuesToLoginUkr.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("http://accounts.dev.ukr.net/registration");
        Thread.sleep(2000);
    }

    @BeforeMethod
    public void runRusLocalization () throws IntrospectionException{
        logger.info("Переключаємося на російську локалізацією");
        $(new Selectors.ByText("Русский")).click();
        assertEquals("Создав ящик, вы сможете перенести в него свою почту из других почтовых сервисов.", $(".import-info__content").getText());
    }

    @AfterMethod
    public void returnUALocalization () throws IntrospectionException{
        logger.info("Переключаємося на українську локалізацією");
        $(new Selectors.ByText("Українська")).click();
        assertEquals("Створивши скриньку, ви зможете перенести в неї свою пошту з інших поштових сервісів.", $(".import-info__content").getText());
    }
    //Блок на помилки в полі "Придумайте ім'я поштової скриньки"
    @Test
    public void test001_checkTitle() throws InterruptedException {
        assertEquals("Регистрация почтового ящика", $(".header__title").getText());
        logger.info("Текст заголовка відповідає вказанному значенню 'Регистрация почтового ящика'");
    }

    @Test
    public void test002_checkLoginForPointSt() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector("#id-login")).sendKeys(".test2.1_0105_001");
        Thread.sleep(100);
        assertEquals("Символ . (точка) не может использоваться в начале и(или) в конце", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про використання крапки на початку логіна відповідає вимогам 'Символ . (точка) не может использоваться в начале и(или) в конце'");
    }

    @Test
    public void test003_checkLoginForPointEn() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector("#id-login")).sendKeys("test2.1_0105_001.");
        Thread.sleep(100);
        assertEquals("Символ . (точка) не может использоваться в начале и(или) в конце", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про використання крапки на початку логіна відповідає вимогам 'Символ . (точка) не может использоваться в начале и(или) в конце'");
    }

    @Test
    public void test004_checkLoginForPointDo() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector("#id-login")).sendKeys("test2..1_0105_001");
        Thread.sleep(100);
        assertEquals("Многократное использование символа . (точка) невозможно", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про використання крапки багаторазово для логіна відповідає вимогам 'Многократное использование символа . (точка) невозможно'");
    }

    @Test
    public void test005_clearLoginField() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector(".verifier__send.is-disabled")).click();
        Thread.sleep(100);
        assertEquals("Поле должно быть заполнено", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про незаповнене поле логіну відповідає логіна відповідає вимогам 'Поле должно быть заполенно'");
    }

    @Test
    public void test006_duplicateMail() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        Thread.sleep(100);
        $(By.cssSelector("#id-login")).sendKeys("test2.1_3004_001");
        assertEquals("К сожалению, ящик с таким именем занят", $(".login-suggestions__error").getText());
        logger.info("Повідомлення про зайняте ім'я логіна відповідає вимогам 'К сожалению, ящик с таким именем занят'");
    }

    @Test
    public void test007_cirilicSymbol() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        Thread.sleep(100);
        $(By.cssSelector("#id-login")).sendKeys("testс2.1_3004_001");
        assertEquals("Имя почтового ящика не может содержать символы КИРИЛЛИЦЫ", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про кириличний символ в імені логіна відповідає вимогам 'Имя почтового ящика не может содержать символы КИРИЛЛИЦЫ'");
    }

    @Test
    public void test008_symbolNotValid() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        Thread.sleep(100);
        $(By.cssSelector("#id-login")).sendKeys("test2.1_3004_001`");
        assertEquals("Имя почтового ящика может содержать только символы _-. (подчеркивание, дефис и точка)", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про кириличний символ в імені логіна відповідає вимогам 'Имя почтового ящика может содержать только символы _-. (подчеркивание, дефис и точка)'");
    }

//    @Test
//    public void test010_symbolLimitSymbol33() throws InterruptedException {
//        $(By.cssSelector("#id-login")).clear();
//        $(By.cssSelector("#id-login")).sendKeys("test2.1_0105_001-acdfghnrmemsm131");
//        assertEquals("test2.1_0105_001-acdfghnrmemsm13", $("#id-login").getText());
//        logger.info("Можна ввести лише 32 символи");
//    }

//@AfterTest
}