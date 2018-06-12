package net.ukr.dev.LoginPageToAccounts;

import net.ukr.dev.BasesClassesForTests.BaseTests;
import net.ukr.dev.helpers.ApachePOIreadHelper;
import net.ukr.dev.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertTrue;

@Test
public class LoginTest extends BaseTests {

    @DataProvider
    public Object[][] rightDataForLogin (Method method){

        ApachePOIreadHelper excelReader = new ApachePOIreadHelper();
        File file = new File("D:/AutomationTest/authtest/src/test/java/net/ukr/dev/data_file/login_data.xlsx");
        excelReader.setExcelFile(String.valueOf(file), "LoginTest");
        List rowsNo = excelReader.getRowContains(method.getName(), 0 );
        return excelReader.getTableArray(rowsNo);
    }

    @Test(dataProvider = "rightDataForLogin")
    public void loginPasswordData(ArrayList data) throws InterruptedException {
        String login = String.valueOf(data.get(0));
        String password = String.valueOf(data.get(1));
        String userName = String.valueOf(data.get(2));

        open("http://newfront.dev.ukr.net/desktop/login?drop_reason=logout");
        Thread.sleep(2000);

        LoginPage passPage = new LoginPage();
        passPage.loginName(login);
        passPage.setPassword(password);
        passPage.submit();
        $("html/body/div[1]/div[2]/header/div[1]/div[2]/a/p").shouldHave(text(userName));
        assertTrue("No user found.",$("html/body/div[1]/div[2]/header/div[1]/div[2]/a/p").getText().equals(userName));
        Thread.sleep(2000);
    }
}
