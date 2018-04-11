package net.ukr.dev;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertTrue;

public class SetupTests  {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/authtest/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://accounts.dev.ukr.net");
    }

    @Test
    public void openPage() {
        driver.get("http://accounts.dev.ukr.net/registration");
        assertTrue("Page open successes", $(".header__title").getText().equals("Регистрация почтового ящика"));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }

}
