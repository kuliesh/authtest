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
    final static Logger logger = Logger.getLogger(net.ukr.dev.createMail.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("http://newfront.dev.ukr.net/desktop/login");
//        $(By.cssSelector("#id-1")).sendKeys("s.kuliesh");
//        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
//        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
    }

    @Test
    public void createMail001() throws InterruptedException {

        $(By.cssSelector("#id-1")).sendKeys("skuliesh");
        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();

        int i=1;
            while (i<=95) {

                Random r = new Random();
                char c = (char)('a' + r.nextInt(32));
                char d = (char)('а' + r.nextInt(128));

            $(".default.compose").click();
            Thread.sleep(500);
            //$("screens").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input.input").sendKeys("s.kuliesh@dev.ukr.net");
            $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
            $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Привіт" + c+d);

//            By iframeBodyMail = By.cssSelector("iframe#mce_0_ifr");
//            switchTo().frame($(iframeBodyMail));
//            $(By.cssSelector("#tinymce>div")).click();
//            Thread.sleep(2000);
//            //$(By.cssSelector("#tinymce>div")).sendKeys("Бармалей самий класний"+c);
//            $(By.cssSelector("body#tinymce > div")).shouldBe(Condition.exist);//.sendKeys("Бармалей самий класний"+c);
//            switchTo().defaultContent();

            $(".default.send").click();
            i++;
            Thread.sleep(500);
        }
        $(".login-button__menu-icon").click();
            $("#login__logout>b").click();
    }

    @Test
    public void createMail002() throws InterruptedException {

        $(By.cssSelector("#id-1")).sendKeys("old054");
        $(By.cssSelector("#id-2")).sendKeys("33333wwww");
        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();

        int i=1;
        while (i<=95) {

            Random r = new Random();
            char c = (char)('a' + r.nextInt(32));
            char d = (char)('а' + r.nextInt(128));

            $(".default.compose").click();
            Thread.sleep(500);
            //$("screens").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input.input").sendKeys("s.kuliesh@dev.ukr.net");
            $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
            $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Здарова" + c+d);

//            By iframeBodyMail = By.cssSelector("iframe#mce_0_ifr");
//            switchTo().frame($(iframeBodyMail));
//            $(By.cssSelector("#tinymce>div")).click();
//            Thread.sleep(2000);
//            //$(By.cssSelector("#tinymce>div")).sendKeys("Бармалей самий класний"+c);
//            $(By.cssSelector("body#tinymce > div")).shouldBe(Condition.exist);//.sendKeys("Бармалей самий класний"+c);
//            switchTo().defaultContent();

            $(".default.send").click();
            i++;
            Thread.sleep(500);
        }
        $(".login-button__menu-icon").click();
        $("#login__logout>b").click();

    }

    @Test
    public void createMail003() throws InterruptedException {

        $(By.cssSelector("#id-1")).sendKeys("new090");
        $(By.cssSelector("#id-2")).sendKeys("3333qqqq");
        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();

        int i=1;
        while (i<=95) {

            Random r = new Random();
            char c = (char)('a' + r.nextInt(32));
            char d = (char)('а' + r.nextInt(128));

            $(".default.compose").click();
            Thread.sleep(500);
            //$("screens").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input.input").sendKeys("s.kuliesh@dev.ukr.net");
            $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
            $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Здарова" + c+d);

//            By iframeBodyMail = By.cssSelector("iframe#mce_0_ifr");
//            switchTo().frame($(iframeBodyMail));
//            $(By.cssSelector("#tinymce>div")).click();
//            Thread.sleep(2000);
//            //$(By.cssSelector("#tinymce>div")).sendKeys("Бармалей самий класний"+c);
//            $(By.cssSelector("body#tinymce > div")).shouldBe(Condition.exist);//.sendKeys("Бармалей самий класний"+c);
//            switchTo().defaultContent();

            $(".default.send").click();
            i++;
            Thread.sleep(500);
        }
        $(".login-button__menu-icon").click();
        $("#login__logout>b").click();

    }

    @Test
    public void createMail004() throws InterruptedException {

        $(By.cssSelector("#id-1")).sendKeys("new159");
        $(By.cssSelector("#id-2")).sendKeys("qqqqqq09");
        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();

        int i=1;
        while (i<=95) {

            Random r = new Random();
            char c = (char)('a' + r.nextInt(32));
            char d = (char)('а' + r.nextInt(128));

            $(".default.compose").click();
            Thread.sleep(500);
            //$("screens").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
            $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input.input").sendKeys("s.kuliesh@dev.ukr.net");
            $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
            $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Здарова" + c+d);

//            By iframeBodyMail = By.cssSelector("iframe#mce_0_ifr");
//            switchTo().frame($(iframeBodyMail));
//            $(By.cssSelector("#tinymce>div")).click();
//            Thread.sleep(2000);
//            //$(By.cssSelector("#tinymce>div")).sendKeys("Бармалей самий класний"+c);
//            $(By.cssSelector("body#tinymce > div")).shouldBe(Condition.exist);//.sendKeys("Бармалей самий класний"+c);
//            switchTo().defaultContent();

            $(".default.send").click();
            i++;
            Thread.sleep(500);
        }
        $(".login-button__menu-icon").click();
        $("#login__logout>b").click();

    }

//    @Test
//    public void createMail005() throws InterruptedException {
//
//        $(By.cssSelector("#id-1")).sendKeys("test2.1_3004_001");
//        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
//        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
//
//        int i=1;
//        while (i<=2) {
//
//            Random r = new Random();
//            char c = (char)('a' + r.nextInt(32));
//            char d = (char)('а' + r.nextInt(128));
//
//            $(".default.compose").click();
//            Thread.sleep(500);
//            //$("screens").click();
//            $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
//            $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input.input").sendKeys("s.kuliesh@dev.ukr.net");
//            $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
//            $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Здарова" + c+d);
//
////            By iframeBodyMail = By.cssSelector("iframe#mce_0_ifr");
////            switchTo().frame($(iframeBodyMail));
////            $(By.cssSelector("#tinymce>div")).click();
////            Thread.sleep(2000);
////            //$(By.cssSelector("#tinymce>div")).sendKeys("Бармалей самий класний"+c);
////            $(By.cssSelector("body#tinymce > div")).shouldBe(Condition.exist);//.sendKeys("Бармалей самий класний"+c);
////            switchTo().defaultContent();
//
//            $(".default.send").click();
//            i++;
//            Thread.sleep(500);
//        }
//        $(".login-button__menu-icon").click();
//        $("#login__logout>b").click();
//
//    }
//
//    @Test
//    public void createMail006() throws InterruptedException {
//
//        $(By.cssSelector("#id-1")).sendKeys("test2.0_2604_002");
//        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
//        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
//
//        int i=1;
//        while (i<=2) {
//
//            Random r = new Random();
//            char c = (char)('a' + r.nextInt(32));
//            char d = (char)('а' + r.nextInt(128));
//
//            $(".default.compose").click();
//            Thread.sleep(500);
//            //$("screens").click();
//            $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
//            $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input.input").sendKeys("s.kuliesh@dev.ukr.net");
//            $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
//            $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Здарова" + c+d);
//
////            By iframeBodyMail = By.cssSelector("iframe#mce_0_ifr");
////            switchTo().frame($(iframeBodyMail));
////            $(By.cssSelector("#tinymce>div")).click();
////            Thread.sleep(2000);
////            //$(By.cssSelector("#tinymce>div")).sendKeys("Бармалей самий класний"+c);
////            $(By.cssSelector("body#tinymce > div")).shouldBe(Condition.exist);//.sendKeys("Бармалей самий класний"+c);
////            switchTo().defaultContent();
//
//            $(".default.send").click();
//            i++;
//            Thread.sleep(500);
//        }
//        $(".login-button__menu-icon").click();
//        $("#login__logout>b").click();
//
//    }
//
//    @Test
//    public void createMail007() throws InterruptedException {
//
//        $(By.cssSelector("#id-1")).sendKeys("test2.0_2604_003");
//        $(By.cssSelector("#id-2")).sendKeys(",fhvfktq!!");
//        $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit")).click();
//
//        int i=1;
//        while (i<=2) {
//
//            Random r = new Random();
//            char c = (char)('a' + r.nextInt(32));
//            char d = (char)('а' + r.nextInt(128));
//
//            $(".default.compose").click();
//            Thread.sleep(500);
//            //$("screens").click();
//            $(".sendmsg__form-label-field.auto.cropped.ui-sortable").click();
//            $(".sendmsg__form-label-field.auto.cropped.ui-sortable>input.input").sendKeys("s.kuliesh@dev.ukr.net");
//            $(By.xpath("//section[1]/div[4]/div[2]/input")).click();
//            $(By.xpath("//section[1]/div[4]/div[2]/input")).sendKeys("Здарова" + c+d);
//
////            By iframeBodyMail = By.cssSelector("iframe#mce_0_ifr");
////            switchTo().frame($(iframeBodyMail));
////            $(By.cssSelector("#tinymce>div")).click();
////            Thread.sleep(2000);
////            //$(By.cssSelector("#tinymce>div")).sendKeys("Бармалей самий класний"+c);
////            $(By.cssSelector("body#tinymce > div")).shouldBe(Condition.exist);//.sendKeys("Бармалей самий класний"+c);
////            switchTo().defaultContent();
//
//            $(".default.send").click();
//            i++;
//            Thread.sleep(500);
//        }
//        $(".login-button__menu-icon").click();
//        $("#login__logout>b").click();
//
//    }
}
