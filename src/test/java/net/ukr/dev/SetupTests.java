package net.ukr.dev;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class SetupTests  {

    @BeforeClass
    public static void setup() {
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/authtest/chromedriver.exe");
        open("http://accounts.dev.ukr.net");
    }

    @Test
    public void openPage() {
        open("http://accounts.dev.ukr.net/registration");
        assertEquals("Реєстрація поштової скриньки", $(".header__title").getText());
    }

    @AfterClass
    public static void tearDown(){
       // driver.close();
        //driver.quit();
    }

}
