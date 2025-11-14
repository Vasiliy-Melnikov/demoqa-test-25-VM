package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.StateCityComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final CalendarComponent calendar = new CalendarComponent();
    private final StateCityComponent stateCity = new StateCityComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage removeAds() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public PracticeFormPage selectGender(String genderText) {
        $("#genterWrapper").$(byText(genderText)).click();
        return this;
    }

    public PracticeFormPage setMobile(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String month, String year, String day) {
        calendar.setDate(month, year, day);
        return this;
    }

    public PracticeFormPage addSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby(String hobbyText) {
        SelenideElement hobby = $("#hobbiesWrapper").$(byText(hobbyText));
        hobby.scrollIntoView(true);                         // подскроллили
        executeJavaScript("arguments[0].click();", hobby);  // «жёсткий» клик
        return this;
    }

    public PracticeFormPage uploadPictureFromClasspath(String filename) {
        $("#uploadPicture").uploadFromClasspath(filename);
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public PracticeFormPage selectState(String state) {
        stateCity.selectState(state);
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        stateCity.selectCity(city);
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public void submitExpectingValidation() {
        $("#submit").click();
        // намеренно ничего не ждём — валидная модалка не должна появиться
    }
}