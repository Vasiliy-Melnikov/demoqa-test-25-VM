package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import util.JsUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ResultsModal {

    private final SelenideElement modal = $(".modal-content");
    private final SelenideElement closeButton = $("#closeLargeModal");
    private final ElementsCollection resultRows = $$(".table-responsive tbody tr");

    public ResultsModal shouldAppear() {
        modal.should(appear, Duration.ofSeconds(10));
        return this;
    }

    public ResultsModal shouldNotAppear() {
        modal.shouldNot(appear, Duration.ofSeconds(5));
        return this;
    }

    public ResultsModal shouldHaveRow(String key, String expectedValue) {
        resultRows
                .findBy(text(key))
                .shouldHave(text(expectedValue));
        return this;
    }

    public void close() {
        JsUtils.removeAds();
        closeButton.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", closeButton);
        modal.shouldNot(appear, Duration.ofSeconds(5));
    }
}
