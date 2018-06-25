package net.ukr.dev.TestingWidjet;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import net.ukr.dev.TimeLimiteTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class TestDisplayedElementsForWidgetUkr extends BaseTests {
    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page for testing widget");
        open("http://morty.fwdcdn.com/widget/widget.html"); //відкриваємо сторінку входу до поштової скриньки
    }

    @Test
    public void Wg1_Title (){
        assertEquals("Пошта", $(By.xpath("//form/div[1]/a/text()")).getText());
        logger.info("Заголовок 'Пошта' відображається");
    }
}
