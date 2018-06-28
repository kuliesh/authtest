package resources;

import com.codeborne.selenide.WebDriverRunner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.ukr.dev.BasesClassesForTests.BaseTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginSuccess extends BaseTests {
    final static Logger logger = Logger.getLogger(LoginSuccess.class);

    private Workbook workbook;
    private WritableWorkbook wwbCopy;
    private WritableSheet shSheet;
    private static final String EXCEL_FILE_LOCATION = "/src/test/java/resources/testSampleData.xls";

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page...");
        open("http://accounts-new.dev.ukr.net/login");
        try
        {
            workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
            Sheet sheet = workbook.getSheet(0);
            String cell1 = sheet.getCell(0, 0).getContents();
//            cell1.getType();
            System.out.print(cell1 + ":");    // Test Count + :
           logger.info(cell1);
//            logger.info(cell1.getContents() + ":");
            Cell cell2 = sheet.getCell(0, 1);
//            System.out.println(cell2.getContents());        // 1
//            logger.info(cell2.getContents());
//            rowsCount = sheet.getRows();
//            logger.info(rowsCount);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

            if (workbook != null) {
                workbook.close();
            }
        }


        Sheet sheet1 = workbook.getSheet(0);
        int rowsCount = sheet1.getRows();
        String cell;
        String[] credArray = new String[rowsCount];
        for (int i = 0; i < rowsCount; i++)
        {
            cell = sheet1.getCell(0, i).getContents();
            credArray[i] = cell;
            logger.info(credArray[i]);
        }
    }

    @Test
    public void login() throws InterruptedException {
        Thread.sleep(1000);
        $(By.cssSelector("#id-l")).sendKeys("new151");
        $(By.cssSelector("#id-p")).sendKeys("qqqqqq01");
        $(By.cssSelector("button.button_type-submit.button_size-large.form__submit")).click();
        Thread.sleep(500);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        Thread.sleep(500);
    }

    @Test
    public void login01() throws InterruptedException {
        logger.info("Open page...");
        open("http://accounts-new.dev.ukr.net/login");
        Thread.sleep(500);
        $(By.cssSelector("#id-l")).sendKeys("new151");
        $(By.cssSelector("#id-p")).sendKeys("qqqqqq01");
        $(By.cssSelector("button.button_type-submit.button_size-large.form__submit")).click();
        Thread.sleep(1000);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }
}
