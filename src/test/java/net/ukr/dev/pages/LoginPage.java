package net.ukr.dev.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    private By loginName = (By) $(By.cssSelector("#id-1"));
    private By password = (By) $(By.cssSelector("#id-2"));
    private By submit = (By) $(By.cssSelector(".button.is-type-submit.is-size-large.form__submit"));

    public void loginName(String name) {
        $(loginName).setValue(name);
    }

    public void setPassword(String code) {
        $(password).setValue(code);
    }

    public void submit() {
        $(submit).click();
    }
}