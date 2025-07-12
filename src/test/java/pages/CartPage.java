package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private final ElementsCollection productsCart = $$("[data-js = product-list]");

    @Step("Проверяем есть ли товары в корзине")
    public CartPage checkProductsInCart() {
        productsCart.shouldBe(sizeGreaterThan(0));
        return this;

    }
}
