package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");
    private final SelenideElement stateInput = $("#react-select-3-input");
    private final SelenideElement cityInput = $("#react-select-4-input");

    public void selectState(String state) {
        stateDropdown.scrollIntoView(true).click();
        stateInput.shouldBe(enabled)
                .setValue(state)
                .pressEnter();
    }
    public void selectCity(String city) {
        cityDropdown.scrollIntoView(true).click();
        cityInput.shouldBe(enabled)
                .setValue(city)
                .pressEnter();
    }
}