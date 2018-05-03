package net.ukr.dev;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static org.testng.AssertJUnit.assertEquals;

public class TimeLimiteTest extends BaseTests{
    final static Logger logger = Logger.getLogger(AuthPageTests.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("http://accounts.dev.ukr.net/registration");
        Thread.sleep(2000);
    }

    @Test
    public void test001_timeLimitForName89() throws InterruptedException {
        $(By.cssSelector("#id-login")).clear();
        $(By.cssSelector("#id-login")).sendKeys("test2.1_0105_003");
        Thread.sleep(5396000);
        assertEquals("test2.1_0105_003", $("#id-login").getText());
        Thread.sleep(5404000);
        assertEquals("", $("#id-login").getText());
    }
}
