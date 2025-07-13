package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BeautyPage {

    private final SelenideElement resultProductComponent = $("[data-js='product-grid-result']"),
                                    buttonToCart = $(".product-buy-block__button"),
                                    modalAddCartTitle = $(".backstage-body__title");

    private final ElementsCollection buttonOpenCart = $$(".buttons-block__item button");

    @Step("Открываем страницу с товарами категория Красота")
    public BeautyPage openBeatyPage() {
        open("c/root/krasota");
        return this;
    }

    @Step("Скроллим до списка товаров")
    public BeautyPage scrollToResultProductComponent() {
        resultProductComponent.scrollTo();
        executeJavaScript("window.scrollBy(0, +80);");
        return this;
    }

    @Step("Кликаем по кнопке купить в карточке товара")
    public BeautyPage clickButtonAddToCart() {
        buttonToCart.click();
        return this;
    }

    @Step("Проверяем открытие модального окна")
    public BeautyPage checkOpenModalAddCart() {
        modalAddCartTitle.shouldBe(text("Товар в корзине"));
        return this;
    }

    @Step("Кликаем по кнопке перейти в корзину")
    public BeautyPage clickToCartPage() {
        buttonOpenCart.findBy(text("Перейти в корзину")).click();

        return this;
    }
}
