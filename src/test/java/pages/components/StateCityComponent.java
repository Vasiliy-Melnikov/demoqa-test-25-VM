package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Condition.*;

public class StateCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");

    private final SelenideElement stateInput = $("#react-select-3-input");
    private final SelenideElement cityInput = $("#react-select-4-input");

    public void selectState(String state) {
        stateDropdown.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", stateDropdown);

        stateInput.shouldBe(visible, enabled);
        stateInput.setValue(state);
        stateInput.pressEnter();
    }

    public void selectCity(String city) {
        cityDropdown.scrollIntoView(true);
        cityDropdown.shouldBe(enabled);
        executeJavaScript("arguments[0].click();", cityDropdown);
        cityInput.shouldBe(visible);
        cityInput.shouldNotHave(attribute("disabled"));

        cityInput.setValue(city);
        cityInput.pressEnter();
    }
}