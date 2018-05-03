package net.ukr.dev;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTests {
    final static Logger logger = Logger.getLogger(BaseTests.class);

    @BeforeTest
    public static void setup() {
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "D:/AutomationTest/authtest/chromedriver.exe");
        //open("http://accounts.dev.ukr.net");

    }

    @AfterTest
    public static void tearDown(){
        // driver.close();
        //driver.quit();
    }
}
