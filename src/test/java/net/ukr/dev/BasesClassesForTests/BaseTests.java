package net.ukr.dev.BasesClassesForTests;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTests {
    final static Logger logger = Logger.getLogger(BaseTests.class);

    @BeforeTest
    public static void setup() {
        logger.info("Run browser...");
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/authtest/chromedriver.exe");
    }

    @AfterTest
    public static void tearDown(){
        logger.info("tearDown()");

        WebDriver webDriver = WebDriverRunner.getWebDriver();
        logger.info(webDriver.getClass());
        webDriver.quit();
    }
}
