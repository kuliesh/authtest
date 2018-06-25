package net.ukr.dev.TestingErrorForInputValues;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class TestErrorsWhenInputValuesToLoginUkr extends BaseTests {
    final static Logger logger = Logger.getLogger(TestErrorsWhenInputValuesToLoginUkr.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("http://accounts.ukr.net/registration");
        Thread.sleep(2000);
    }
//Блок на помилки в полі "Придумайте ім'я поштової скриньки"
    @Test
    public void test001_checkTitle() throws InterruptedException {
        assertEquals("Реєстрація поштової скриньки", $(".header__title").getText());
        logger.info("Текст заголовка відповідає вказанному значенню ...");
    }

    @Test
    public void test002_checkLoginForPointSt() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector("#id-login")).sendKeys(".test2.1_0105_001");
        Thread.sleep(100);
        assertEquals("Символ . (крапка) не може використовуватися на початку і(або) в кінці", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про використання крапки на початку логіна відповідає вимогам...");
    }

    @Test
    public void test003_checkLoginForPointEn() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector("#id-login")).sendKeys("test2.1_0105_001.");
        Thread.sleep(100);
        assertEquals("Символ . (крапка) не може використовуватися на початку і(або) в кінці", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про використання крапки вкінці логіна відповідає вимогам...");
    }

    @Test
    public void test004_checkLoginForPointDo() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector("#id-login")).sendKeys("test2..1_0105_001");
        Thread.sleep(100);
        assertEquals("Багаторазове використання символу . (крапка) неможливе", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про використання крапки багаторазову для логіна відповідає вимогам...");
    }

    @Test
    public void test005_clearLoginField() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector(".verifier__send.is-disabled")).click();
        Thread.sleep(100);
        assertEquals("Поле має бути заповнене", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про незаповнене поле логіну відповідає логіна відповідає вимогам...");
    }

    @Test
    public void test006_duplicateMail() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        Thread.sleep(100);
        $(By.cssSelector("#id-login")).sendKeys("test2.1_3004_001");
        assertEquals("На жаль, скринька з таким іменем вже зайнята", $(".login-suggestions__error").getText());
        logger.info("Повідомлення про зайняте ім'я логіна відповідає вимогам...");
    }

    @Test
    public void test007_cirilicSymbol() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        Thread.sleep(100);
        $(By.cssSelector("#id-login")).sendKeys("testс2.1_3004_001");
        assertEquals("Ім'я поштової скриньки не може містити символи КИРИЛИЦІ", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про кириличний символ в імені логіна відповідає вимогам...");
    }

    @Test
    public void test008_symbolNotValid() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        Thread.sleep(100);
        $(By.cssSelector("#id-login")).sendKeys("test2.1_3004_001`");
        assertEquals("Ім'я поштової скриньки може містити тільки символи _-. (підкреслення, дефіс, крапка)", $(".input-default__error.is-size-normal").getText());
        logger.info("Повідомлення про кириличний символ в імені логіна відповідає вимогам...");
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


