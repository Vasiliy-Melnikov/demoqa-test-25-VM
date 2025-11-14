package components;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CalendarComponent {
    public void setDate(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        String dd = String.format("%02d", Integer.parseInt(day));

        $$(".react-datepicker__day--0" + dd)
                .filterBy(not(cssClass("react-datepicker__day--outside-month")))
                .first()
                .click();

        // $(".react-datepicker__day--0" + dd + ":not(.react-datepicker__day--outside-month)").click();
    }
}