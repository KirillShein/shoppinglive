package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;

public class OnlineTVPage {

    private final SelenideElement buttonPlay = $(".play-button"),
                                    videoPlay = $(".video-js");

    @Step("Кликаем по кнопке видео-проигрователя")
    public OnlineTVPage clickButtonPlay() {
        executeJavaScript("window.scrollBy(0, +120);");
        buttonPlay.click();
        sleep(2000);
        return this;
    }

    @Step("Проверяем что трансляция работает")
    public OnlineTVPage checkPlayTV() {
        videoPlay.has(cssClass("vjs-playing"));
        return this;
    }
}
