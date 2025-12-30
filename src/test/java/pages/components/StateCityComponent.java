package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Condition.visible;

public class StateCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");

    public void selectState(String state) {
        stateDropdown.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", stateDropdown);

        SelenideElement input = $("#react-select-3-input")
                .shouldBe(visible);

        input.setValue(state);
        input.pressEnter();
    }

    public void selectCity(String city) {
        cityDropdown.scrollIntoView(true);
        executeJavaScript("arguments[0].click();", cityDropdown);

        SelenideElement input = $("#react-select-4-input")
                .shouldBe(visible);

        input.setValue(city);
        input.pressEnter();
    }
}