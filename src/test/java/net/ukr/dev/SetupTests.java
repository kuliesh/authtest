package net.ukr.dev;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class SetupTests  {

    @BeforeClass
    public static void setup() {
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/authtest/chromedriver.exe");
        Configuration.timeout=5000;
        Configuration.startMaximized=true;
        open("http://newfront.dev.ukr.net/desktop/login");
        $(byLinkText("Створити скриньку")).click();
        assertEquals("Реєстрація поштової скриньки", $(".header__title").getText());

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
    }

}
