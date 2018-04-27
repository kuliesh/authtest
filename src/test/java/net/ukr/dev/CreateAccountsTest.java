package net.ukr.dev;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class CreateAccountsTest extends SetupTests {

    @Test
    public void test001_CreateUser() throws InterruptedException {
    $(byId("id-login")).sendKeys("test1.4_2704_012");
    $(byId("id-password")).sendKeys(",fhvfktq!!");
    $(byId("id-password-repeat")).sendKeys(",fhvfktq!!");
    $(byId("id-first-name")).sendKeys("as");
    $(byXpath("html/body/div[1]/div/main/form/section[3]/section[1]/div/div[2]/input")).sendKeys("sd");
    $(byId("id-birth-day")).sendKeys("1");
    $(byXpath("html/body/div[1]/div/main/form/section[3]/section[2]/div/section/div")).click();
    $(byCssSelector("ul.input-select__list li.input-option")).click();
    $(byXpath("html/body/div[1]/div/main/form/section[3]/section[2]/div/div[2]/input")).sendKeys("2000");
    $(byXpath("html/body/div[1]/div/main/form/section[3]/section[3]/div/div[1]/label[1]")).click();
    $(byId("id-mobile")).click();
    $(byId("id-mobile")).sendKeys("975711626");
    $(byXpath("html/body/div[1]/div/main/form/section[7]/button")).click();
    Thread.sleep(10000);
    $(byXpath("html/body/div[1]/div/main/form/section[9]/div/label[1]")).click();
    Thread.sleep(2000);
    $(byCssSelector(".submit")).click();
    Thread.sleep(5000);
    assertEquals("Ваша поштова адреса — test1.0_2704_001@dev.ukr.net", $(".msglist__empty>td").getText());
    }

}
