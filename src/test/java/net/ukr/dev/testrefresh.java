package net.ukr.dev;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class testrefresh extends createMail {
    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);
    @Test
            public void refreshTest(){
    open("http://newfront.dev.ukr.net/desktop/login");
        refresh();
    logger.info("УРА.......");
    }
}
