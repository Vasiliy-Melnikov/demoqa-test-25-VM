package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CalendarComponent {

    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement monthSelect      = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect       = $(".react-datepicker__year-select");
    private final ElementsCollection allDays       = $$(".react-datepicker__day");

    public void setDate(String month, String year, String day) {
        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);

        String dd = String.format("%02d", Integer.parseInt(day));

        allDays
                .filterBy(cssClass("react-datepicker__day--0" + dd))
                .filterBy(not(cssClass("react-datepicker__day--outside-month")))
                .first()
                .click();
    }
}