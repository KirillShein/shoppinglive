package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    private final SelenideElement buttonApplyOrder = $("[data-js = button-apply-order]"),
                                  buttonQuickOrder = $("[data-js = button-fast-order]");

    private final ElementsCollection productsCart = $$("[data-js = product-list]");

    @Step("Проверяем есть ли товары в корзине")
    public CartPage checkProductsInCart() {
        productsCart.shouldBe(sizeGreaterThan(0));
        return this;

    }

    @Step("Скролим до кнопки Быстрый заказ")
    public CartPage scrollToButtonQuickOrder() {
        buttonApplyOrder.scrollTo();
        return this;
    }

    @Step("Кликаем по кнопке Быстрый заказ")
    public CartPage clickButtonQuickOrder() {
        buttonQuickOrder.click();

        return this;
    }
}
