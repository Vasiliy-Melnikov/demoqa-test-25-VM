package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class StateCityComponent {

    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");

    public void selectState(String state) {
        stateDropdown.click();
        stateCityWrapper.$(byText(state)).click();
    }

    public void selectCity(String city) {
        cityDropdown.click();
        stateCityWrapper.$(byText(city)).click();
    }
}
