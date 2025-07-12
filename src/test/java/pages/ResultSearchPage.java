package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultSearchPage {

    private final SelenideElement nameCardProduct = $(".digi-product__label");

    @Step("Проверяем что в названии товара совпадает с текстом который вводили в поисковике")
    public ResultSearchPage checkNameCardProduct(String text) {
        nameCardProduct.shouldBe(text(text));
        return this;
    }
}
