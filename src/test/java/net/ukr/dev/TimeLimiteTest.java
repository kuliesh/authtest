package net.ukr.dev;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class TimeLimiteTest extends BaseTests {
    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("http://accounts-new.dev.ukr.net/login");
        Thread.sleep(2000);
        $(By.cssSelector("#id-l")).sendKeys("s.kuliesh");
        $(By.cssSelector("#id-p")).sendKeys(",fhvfktq4");
        $(By.cssSelector(".button.button_type-submit.button_size-large.form__submit")).click();
    }

//    @Test
//    public void test001_timeLimitForName89() throws InterruptedException {
//        $(By.cssSelector("#id-login")).clear();
//        $(By.cssSelector("#id-login")).sendKeys("test2.1_0105_003");
//        Thread.sleep(5396000);
//        assertEquals("test2.1_0105_003", $("#id-login").getText());
//        Thread.sleep(5404000);
//        assertEquals("", $("#id-login").getText());
//    }

    @Test
    public void test002_calculateLimitInputPass() throws InterruptedException {

        $(By.cssSelector(".login-button__menu-icon")).click();
        $(By.xpath("html/body/div[1]/div[2]/header/div[1]/div/div/div/div[3]/a[4]")).click();
        //open("http://gamma.dev.ukr.net/desktop#security/personalData");
        Thread.sleep(2000);
        $(By.xpath("html/body/div[2]/main/section[5]/div/div/div/button/div/text()")).click();
        Thread.sleep(500);

        int i=1;
        while (i<=101) {

            Random r = new Random();
            char c = (char)('a' + r.nextInt(64));

            $(By.cssSelector("#id-privilege-password")).sendKeys(","+c);
            $(By.cssSelector(".button.button_type-submit.button_size-normal.popup-confirm__button")).click();
            assertEquals("Неправильний пароль", $(".input-text__error").getText());

            i++;
            Thread.sleep(1000);
        }

        Thread.sleep(10000);
        assertEquals("Неправильний пароль", $(".input-text__error").getText());
    }
}
