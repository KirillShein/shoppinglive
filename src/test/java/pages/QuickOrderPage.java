package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class QuickOrderPage {

    private final SelenideElement inputPhone = $x("//label[contains(text(), 'Телефон')]/../input"),
                                    inputEmail = $x("//label[contains(text(), 'Почта')]/../input"),
                                    inputName = $x("//label[contains(text(), 'Имя')]/../input"),
                                    body = $("body");

    private final ElementsCollection buttonContinue = $$("button"),
                                    titleModal = $$(".backstage-body__title");

    @Step("Вводим номер телефона")
    public QuickOrderPage setPhone(String phone) {
        inputPhone.scrollTo().click();
        inputPhone.setValue(phone);
        return this;
    }

    @Step("Вводим email")
    public QuickOrderPage setEmail(String email) {
        inputEmail.scrollTo().click();
        inputEmail.setValue(email);
        body.click();

        return this;
    }

    @Step("Вводим имя")
    public QuickOrderPage setName(String name) {
        inputName.scrollTo().click();
        inputName.setValue(name);
        body.click();

        return this;
    }

    @Step("Кликаем по кнопке Продолжить")
    public QuickOrderPage clickButtonContinue() {
        buttonContinue.findBy(text("Продолжить")).click();

        return this;
    }

    @Step("Проверяем, что открылось модальное окно")
    public QuickOrderPage checkOpenModal() {
        titleModal.findBy(text("Введите код подтверждения"));

        return this;
    }
}
