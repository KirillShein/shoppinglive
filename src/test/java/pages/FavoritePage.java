package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class FavoritePage {

    private final ElementsCollection favoriteProducts = $$("[data-js-wishlist = 'list']");

    @Step("Проверяем что товары есть на странице Избранное")
    public FavoritePage setFavoriteProducts() {
        favoriteProducts.shouldBe(sizeGreaterThan(0));
        return this;
    }
}
