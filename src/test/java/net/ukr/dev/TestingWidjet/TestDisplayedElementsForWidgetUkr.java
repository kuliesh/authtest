package net.ukr.dev.TestingWidjet;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import net.ukr.dev.TimeLimiteTest;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TestDisplayedElementsForWidgetUkr extends BaseTests {
    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page for testing widget");
        open("https://www.ukr.net/"); //відкриваємо сторінку входу до поштової скриньки
    }

    @Test
    public void Wg1_Title (){
        assertEquals("Пошта", $((".login-block__title")).getText());
        logger.info("Заголовок 'Пошта' відображається");
    }

    @Test
    public void Wg1_TitleClick (){

    }

    @Test
    public void Wg2_FieldLogin (){
        assertTrue($(("#id-input-login")).isDisplayed());
        logger.info("Поле 'Ім’я вашої скриньки' відображається");
    }

    @Test
    public void Wg3_FieldPassword (){
        assertTrue($(("#id-input-password")).isDisplayed());
        logger.info("Поле 'Пароль' відображається");
    }

    @Test
    public void Wg4_CheckBoxOthComp (){
        assertTrue($((".form__short-session-label")).isDisplayed());
        logger.info("Чекбокс 'Чужий комп'ютер' відображається");
        assertEquals("Чужий комп'ютер", $(".form__short-session-label").getText());
        logger.info("Строка 'Чужий комп'ютер' відображається");
    }

    @Test
    public void Wg5_ButtonEnter (){
        assertEquals("Create Your @UKR.NET Mailbox", $(".header__title").getText());
        logger.info("Строка 'Create Your @UKR.NET Mailbox' відображається");
    }

    @Test
    public void Wg6_ButtonNotEnter (){
        assertEquals("Create Your @UKR.NET Mailbox", $(".header__title").getText());
        logger.info("Строка 'Create Your @UKR.NET Mailbox' відображається");
    }

    @Test
    public void Wg6_ButtonNotEnterClick (){
        assertEquals("Create Your @UKR.NET Mailbox", $(".header__title").getText());
        logger.info("Строка 'Create Your @UKR.NET Mailbox' відображається");
    }

    @Test
    public void Wg7_ButtonCreate (){
        assertEquals("Create Your @UKR.NET Mailbox", $(".header__title").getText());
        logger.info("Строка 'Create Your @UKR.NET Mailbox' відображається");
    }

    @Test
    public void Wg7_ButtonCreateClick (){
        assertEquals("Create Your @UKR.NET Mailbox", $(".header__title").getText());
        logger.info("Строка 'Create Your @UKR.NET Mailbox' відображається");
    }
}
