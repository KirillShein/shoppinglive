package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement searchForm = $(".field-search__form"),
                                  searchInput = $("#site-search-input"),
                                  collectionWithGoods = $(".collection-with-goods"),
                                  favoriteIcon = $(".product-card-item__actives"),
                                  favoriteIconHeader = $(".wish-bts"),
                                  iconTV = $(".image-default");

    private final ElementsCollection popupItems = $$(".header-pop-up__item a");

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open(baseUrl);
        return this;
    }

    @Step("Кликаем по поиску")
    public MainPage clickSearchForm() {
        searchForm.click();
        return this;
    }

    @Step("Вводим в поиск текст")
    public MainPage enterTextInSearchInput(String text) {
        searchInput.setValue(text).pressEnter();
        return this;
    }

    @Step("Скроллим до компонента Товар дня")
    public MainPage scroolToCollectionWithGoods() {
        sleep(2000);
        collectionWithGoods.scrollTo();
        executeJavaScript("window.scrollBy(0, -50);");
        return this;
    }

    @Step("Кликаем по иконке сердечко в карточке товара")
    public MainPage clickFavoriteIcon() {
        favoriteIcon.click();
        return this;
    }

    @Step("Кликаем по иконке сердечко по шапке сайта")
    public MainPage clickIconToFavoritePage() {
        favoriteIconHeader.click();
        return this;
    }

    @Step("Наводим на иконку ТВ")
    public MainPage clickIconTV() {
        iconTV.hover();

        return this;
    }

    @Step("В pop-up сликаем по Прямой эфир")
    public MainPage clickPopItemToOnlineTVPage() {
        popupItems.findBy(text("Прямой эфир")) // Находит первый подходящий элемент
                .click();
        return this;
    }

}
