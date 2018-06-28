package net.ukr.dev.BasesClassesForTests;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTests {
    final static Logger logger = Logger.getLogger(BaseTests.class);

    @Parameters(value="browser")
    //@BeforeTest
    @BeforeClass
    public static void setup(String browser) {
        logger.info("Run browser "+browser+"...");

        if("chrome".equals(browser)) {
            logger.info("browser is Chrome");
            System.setProperty("selenide.browser", "chrome");
            System.setProperty("webdriver.chrome.driver", "/Users/peremozec/Documents/chromedriver.exe");
            WebDriver webDriverChrome = new ChromeDriver();
            WebDriverRunner.setWebDriver(webDriverChrome);
        }
        if("firefox".equals(browser)){
            logger.info("browser is firefox");
            System.setProperty("webdriver.chrome.driver", "/Users/peremozec/Documents/geckodriver.exe");
            WebDriver webDriverFirefox = new FirefoxDriver();
            WebDriverRunner.setWebDriver(webDriverFirefox);
        }
    }

    //@AfterTest
    //@Parameters(value="browser")
    @AfterClass(alwaysRun=true)
    public static void tearDown(){
        logger.info("tearDown()");

        WebDriver webDriver = WebDriverRunner.getWebDriver();
        logger.info(webDriver.getClass());
        webDriver.quit();
    }
}
