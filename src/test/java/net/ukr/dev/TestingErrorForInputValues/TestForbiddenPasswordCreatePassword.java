package net.ukr.dev.TestingErrorForInputValues;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import net.ukr.dev.helpers.ApachePOIreadHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertFalse;

@Test
public class TestForbiddenPasswordCreatePassword extends BaseTests {
    final static Logger logger = Logger.getLogger(net.ukr.dev.TestingErrorForInputValues.TestForbiddenPasswordCreatePassword.class);

    //Активація дата провайдера
    @DataProvider
    public Object[][] errorDataForPasswordUa (Method method){

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D://AutomationTest/authtest/data_file/forbidden_password.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "ForbiddenTest");
        List rowsNo = excelReader.getRowContains(method.getName(), 0 );
        return excelReader.getTableArray(rowsNo);
    }

    @Test(dataProvider = "errorDataForPasswordUa")
    //формування масиву даних з файла, що був оброблений дата провайдером
    public void forbiddenPassword(ArrayList data) throws InterruptedException {
        String testName = String.valueOf(data.get(0));
        String inputPassword = String.valueOf(data.get(1));
        String displayedError = String.valueOf(data.get(2));
        logger.info("testName = " + testName);
        logger.info("inputPassword = " + inputPassword);
        logger.info("displayedError = " + displayedError);

        open("https://accounts.ukr.net/registration");
        Thread.sleep(2000);

        //Вже сам тест
        $(By.cssSelector("#id-password")).sendKeys(inputPassword);
        $(By.cssSelector("#id-password-repeat")).click();
        $(By.cssSelector(".input-default__error.is-size-normal")).shouldHave(text(displayedError));
        assertFalse("No user found.",$(By.cssSelector(".input-default__error.is-size-normal")).getText().equals(displayedError));
        Thread.sleep(2000);
        refresh();
    }
}
