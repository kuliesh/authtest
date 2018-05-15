package net.ukr.dev;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class createMail extends BaseTests {
    final static Logger logger = Logger.getLogger(net.ukr.dev.VerifiteTextOnMailTests.class);

    Random r = new Random();
    char c = (char)('а' + r.nextInt(32));

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("https://mail.ukr.net/desktop/login");
        $(By.cssSelector("#id-1")).sendKeys("sms2mail");
        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
        Thread.sleep(2000);
    }

    @Test
    public void createMail() throws InterruptedException {
        $(".default.compose").click();
//        $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
//        $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input").sendKeys("skuliesh@dev.ukr.net");
        $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
        $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Привіт"+c);
//        $(By.cssSelector("#tinymce>div")).click();
//        $(By.xpath("html/body/div[1]")).sendKeys("Бармалей самий класний"+c);
        $(".default.send").click();
        Thread.sleep(100);
    }
}
