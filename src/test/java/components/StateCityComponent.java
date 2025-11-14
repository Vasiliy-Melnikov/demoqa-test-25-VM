package components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {
    public void selectState(String state) {
        $("#state").click();
        $(byText(state)).click();
    }

    public void selectCity(String city) {
        $("#city").click();
        $(byText(city)).click();
    }
}
