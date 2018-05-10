package net.ukr.dev.TestingTheDesignOfThePageInterface;

import com.codeborne.selenide.Selectors;
import net.ukr.dev.BaseTests;
import net.ukr.dev.TimeLimiteTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

/**
 * **********************************************************************
 * @Project Name : AuthTestAutomation  - Selenium Framework.
 * @TestSet Name : VerifiedNameElementsPageOfRegistrationRu
 * @Description : Verified Name Elements on Page Of Registration for Ru localization
 * @TestHeader : VerifiedNameElementsPageOfRegistrationRu
 * @Date : 10-May-2018
 * @Author :  Sergii Kuliesh
 * **********************************************************************
 */

public class VerifiedNameElementsPageOfRegistrationRu extends BaseTests {

    final static Logger logger = Logger.getLogger(TimeLimiteTest.class);

    @BeforeClass
    public void openPage() throws InterruptedException {
        logger.info("Open page of registration");
        open("http://newfront.dev.ukr.net/desktop/login"); //відкриваємо сторінку входу до поштової скриньки
        $(By.linkText("Створити скриньку")).click(); //переходимо на сторінку реєстрації поштової скриньки
        Thread.sleep(2000);
        //Перевірка, що локалізація вибрана як "Русский"
        $(new Selectors.ByText("Русский")).click();
        assertEquals("Русский",$("button[class='header__lang-item is-current'] > span[class='header__lang-long-name']").getText());
        logger.info("Вибрана росийська мова.");
    }

    @Test
    public void test001_VerifyTextWithoutElements(){

        //Первіряємо чи відображаються всі мови для вибору
        assertEquals("Українська", $(By.xpath("//button[1]")).getText());
        logger.info("Строка 'Українська' відображається");
        assertEquals("Русский", $(By.xpath("//button[2]")).getText());
        logger.info("Строка 'Русский' відображається");
        assertEquals("English", $(By.xpath("//button[3]")).getText());
        logger.info("Строка 'English' відображається");

        //Первіряємо чи відображаються всі загальні тексти
        assertEquals("Регистрация почтового ящика", $(".header__title").getText());
        logger.info("Строка 'Регистрация почтового ящика' відображається");
        assertEquals("Создав ящик, вы сможете перенести в него свою почту из других почтовых сервисов.", $(".import-info__content").getText());
        logger.info("Строка 'Создав ящик, вы сможете перенести в него свою почту из других почтовых сервисов' відображається");
//        assertEquals("*Все поля должны содержать корректные данные", $(".annotation").getText());
//        logger.info("Строка '*Все поля должны содержать корректные данные' відображається");
        assertEquals("Нажимая на кнопку «Зарегистрировать ящик», я принимаю условия Соглашения об использовании электронной почты FREEMAIL (mail.ukr.net).", $(".confirm-terms").getText());
        logger.info("Строка 'Нажимая на кнопку «Зарегистрировать ящик», я принимаю условия Соглашения об использовании электронной почты FREEMAIL (mail.ukr.net).");
        assertEquals("КРУГЛОСУТОЧНАЯ ПОДДЕРЖКА", $(".footer__support-title").getText());
        logger.info("Строка 'КРУГЛОСУТОЧНАЯ ПОДДЕРЖКА відображається");

        assertEquals("support@ukr.net", $(By.xpath("//li[1]/a")).getText());
        logger.info("Строка 'support@ukr.net' відображається");
        assertEquals("(044) 235-85-55", $(By.xpath("//li[2]/a")).getText());
        logger.info("Строка '(044) 235-85-55' відображається");
        assertEquals("(050) 204-14-24", $(By.xpath("//li[3]/a")).getText());
        logger.info("Строка '204-14-24' відображається");
        assertEquals("(096) 718-55-52", $(By.xpath("//li[4]/a")).getText());
        logger.info("Строка '(096) 718-55-52' відображається");
    }

    @Test
    public void test002_VerifyTextsForElements(){
        //Перевіряємо тексти для полей вводу
        //Поле логіну
        assertEquals("Придумайте имя почтового ящика", $(By.xpath("//section[1]/label")).getText());
        logger.info("Строка 'Придумайте имя почтового ящика' відображається");
        //Поле пароля
        assertEquals("Придумайте пароль", $(By.xpath("//section[2]/label[1]")).getText());
        logger.info("Строка 'Придумайте пароль' відображається");
        //Поле повтору пароля
        assertEquals("Введите пароль повторно", $(By.xpath("//section[2]/label[2]")).getText());
        logger.info("Строка 'Введите пароль повторно' відображається");
        //Поле вводу імені і призвища
        assertEquals("Как вас зовут?", $(By.xpath("//section[3]/label[1]")).getText());
        logger.info("Строка 'Как вас зовут?' відображається");
        //Дати народження
        assertEquals("Дата рождения", $(By.xpath("//section[3]/label[2]")).getText());
        logger.info("Строка 'Дата рождения' відображається");
        //Чекбокс для "Чоловік"
        assertEquals("Мужчина", $(By.xpath("//div/div[1]/label[2]")).getText());
        logger.info("Строка 'Мужчина' відображається");
        //Чекбокс для "Жінка"
        assertEquals("Женщина", $(By.xpath("//div/div[2]/label[2]")).getText());
        logger.info("Строка 'Женщина' відображається");
        //Поле вводу імені відправника
        assertEquals("Имя отправителя", $(By.xpath("//section[4]/label")).getText());
        logger.info("Строка 'Имя отправителя' відображається");
        //Поле вводу резеврної адреси пошти
        assertEquals("Резервный e-mail", $(By.xpath("//section[5]/label")).getText());
        logger.info("Строка 'Резервный e-mail' відображається");
        //Поле вводу мобільного телефону
        assertEquals("Мобильный телефон", $(By.xpath("//section[6]/label")).getText());
        logger.info("Строка 'Мобильный телефон' відображається");

        //Поле з повідомлення для активації
        assertEquals("Почтовый ящик необходимо активировать", $(By.xpath("//section[7]/button/b")).getText());
        logger.info("Строка 'Почтовый ящик необходимо активировать' відображається");
//        assertEquals("На вказаний номер мобільного телефону буде відправлено SMS з кодом активації", $(By.xpath("//section[7]/button/span[1]/text()")).getText());
//        logger.info("Строка 'На вказаний номер мобільного телефону  буде відправлено SMS з кодом активації' відображається");
        assertEquals("ПОЛУЧИТЬ КОД", $(By.xpath("//section[7]/button/span[2]")).getText());
        logger.info("Строка 'ПОЛУЧИТЬ КОД' відображається");

        //Чекбокс для імпорта
        assertEquals("Начать импорт почты из других почтовых сервисов", $(By.xpath("//label[2]/strong")).getText());
        logger.info("Строка 'Начать импорт почты из других почтовых сервисов' відображається");
        //Чекбокс для підтвердження ознайомлення з правилами
        assertEquals("Я предоставляю согласие на обработку персональных данных в соответствии\n" +
                "с Соглашением о конфиденциальности и принимаю его условия.", $(By.xpath("//label[2]/span")).getText());
        logger.info("Строка 'Я предоставляю согласие на обработку персональных данных в соответствии с Соглашением о конфиденциальности и принимаю его условия.' відображається");
        //Кнопка реєстрації
        assertEquals("Зарегистрировать ящик", $(".submit").getText());
        logger.info("Строка 'Зарегистрировать ящик' відображається");
    }
}
