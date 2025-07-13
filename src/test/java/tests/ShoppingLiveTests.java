package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.TestData;

@Tag("regression")
@DisplayName("Позитивные ui-тесты")
public class ShoppingLiveTests extends TestBase {

    TestData testData = new TestData();

    @Test
    @DisplayName("Проверка работы поиска")
    void searchResultTest() {
        mainPage.openMainPage()
                .clickSearchForm()
                .enterTextInSearchInput(testData.searchText);

        resultSearchPage.checkNameCardProduct(testData.searchText);
    }

    @DisplayName("Проверка добавления товара в избранное")
    @Test
    void AddToFavoriteTest() {
        mainPage.openMainPage()
                .scroolToCollectionWithGoods()
                .clickFavoriteIcon()
                .clickIconToFavoritePage();

        favoritePage.setFavoriteProducts();

    }

    @DisplayName("Проверка онлайн трансляции ТВ")
    @Test
    void CheckTVBroadcast() {
        mainPage.openMainPage()
                .clickIconTV()
                .clickPopItemToOnlineTVPage();

        onlineTVPage.clickButtonPlay()
                    .checkPlayTV();
    }


    @DisplayName("Проверка добавления товара в корзину и создания быстрого заказа")
    @Test
    void QuickOrderTest() {
        beautyPage.openBeatyPage()
                .scrollToResultProductComponent()
                .clickButtonAddToCart()
                .checkOpenModalAddCart()
                .clickToCartPage();

        cartPage.scrollToButtonQuickOrder()
                .clickButtonQuickOrder();

        quickOrderPage.setPhone(testData.phone)
                .setEmail(testData.email)
                .setName(testData.name)
                .clickButtonContinue()
                .checkOpenModal();
    }


}
