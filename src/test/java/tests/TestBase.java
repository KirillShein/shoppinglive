package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

public class TestBase {

    MainPage mainPage = new MainPage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();
    FavoritePage favoritePage = new FavoritePage();
    OnlineTVPage onlineTVPage = new OnlineTVPage();
    BeautyPage beautyPage = new BeautyPage();
    CartPage cartPage = new CartPage();
    QuickOrderPage quickOrderPage = new QuickOrderPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.shoppinglive.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}
