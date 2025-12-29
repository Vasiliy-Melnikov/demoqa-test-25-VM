package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StateCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");

    public void selectState(String state) {
        stateDropdown.scrollIntoView(true);
        stateDropdown.shouldBe(visible, enabled);
        executeJavaScript("arguments[0].click();", stateDropdown);

        $(byText(state))
                .shouldBe(visible)
                .click();
    }

    public void selectCity(String city) {
        cityDropdown.scrollIntoView(true);
        cityDropdown.shouldBe(visible, enabled);
        executeJavaScript("arguments[0].click();", cityDropdown);

        $(byText(city))
                .shouldBe(visible)
                .click();
    }
}