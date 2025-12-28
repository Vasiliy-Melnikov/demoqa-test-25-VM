package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.visible;

public class StateCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");

    public void selectState(String state) {
        stateDropdown.scrollIntoView(true);
        stateDropdown.click();
        stateCityWrapper.$(byText(state))
                .shouldBe(visible)
                .click();
    }

    public void selectCity(String city) {
        cityDropdown.scrollIntoView(true);
        cityDropdown.click();
        stateCityWrapper.$(byText(city))
                .shouldBe(visible)
                .click();
    }
}
