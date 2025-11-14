package components;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CalendarComponent {
    public void setDate(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        // дни в календаре имеют классы вида --001, --019, --031
        String dd = String.format("%02d", Integer.parseInt(day));

        // Вариант 1: через коллекцию + Condition.not(cssClass(...))
        $$(".react-datepicker__day--0" + dd)
                .filterBy(not(cssClass("react-datepicker__day--outside-month")))
                .first()
                .click();

        // Вариант 2 (одной строкой, можно вместо варианта 1):
        // $(".react-datepicker__day--0" + dd + ":not(.react-datepicker__day--outside-month)").click();
    }
}