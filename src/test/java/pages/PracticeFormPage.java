package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.StateCityComponent;
import util.JsUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final CalendarComponent calendar = new CalendarComponent();
    private final StateCityComponent stateCity = new StateCityComponent();

    private final SelenideElement firstNameInput   = $("#firstName");
    private final SelenideElement lastNameInput    = $("#lastName");
    private final SelenideElement emailInput       = $("#userEmail");
    private final SelenideElement genderWrapper    = $("#genterWrapper");
    private final SelenideElement mobileInput      = $("#userNumber");
    private final SelenideElement subjectsInput    = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper   = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture    = $("#uploadPicture");
    private final SelenideElement addressTextArea  = $("#currentAddress");
    private final SelenideElement stateDropdown    = $("#state");
    private final SelenideElement cityDropdown     = $("#city");
    private final SelenideElement submitButton     = $("#submit");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage removeAdsOnPage() {
        JsUtils.removeAds();
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage selectGender(String genderText) {
        genderWrapper.$(byText(genderText)).click();
        return this;
    }

    public PracticeFormPage setMobile(String value) {
        mobileInput.setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String month, String year, String day) {
        calendar.setDate(month, year, day);
        return this;
    }

    public PracticeFormPage addSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby(String hobbyText) {
        hobbiesWrapper.$(byText(hobbyText)).click();
        return this;
    }

    public PracticeFormPage uploadPictureFromClasspath(String filename) {
        uploadPicture.uploadFromClasspath(filename);
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        addressTextArea.setValue(value);
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
        submitButton.click();
    }

    public void submitExpectingValidation() {
        submitButton.click();
    }
}