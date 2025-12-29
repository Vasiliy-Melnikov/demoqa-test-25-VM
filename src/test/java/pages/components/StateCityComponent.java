package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.visible;

public class StateCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");

    public void selectState(String state) {
        stateDropdown.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", stateDropdown);

        SelenideElement option = stateCityWrapper.$(byText(state))
                .shouldBe(visible);
        executeJavaScript("arguments[0].click();", option);
    }

    public void selectCity(String city) {
        cityDropdown.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", cityDropdown);

        SelenideElement option = stateCityWrapper.$(byText(city))
                .shouldBe(visible);
        executeJavaScript("arguments[0].click();", option);
    }
}
