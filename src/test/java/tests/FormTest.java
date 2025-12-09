package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultsModal;

public class FormTest extends TestBase {

    private final PracticeFormPage form = new PracticeFormPage();
    private final ResultsModal modal = new ResultsModal();
    private final TestData data = new TestData();

    @Test
    void fillPracticeFormTest() {

        form.openPage()
                .removeAdsOnPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .selectGender(data.gender)
                .setMobile(data.mobile)
                .setBirthDate(data.birthMonth, data.birthYear, data.birthDay)
                .addSubject(data.subject1)
                .addSubject(data.subject2)
                .selectHobby(data.hobby1)
                .selectHobby(data.hobby2)
                .selectHobby(data.hobby3)
                .uploadPictureFromClasspath(data.picture)
                .setAddress(data.currentAddress)
                .selectState(data.state)
                .selectCity(data.city)
                .submit();

        modal.shouldAppear()
                .shouldHaveRow("Name", data.fullName)
                .shouldHaveRow("Email", data.email)
                .shouldHaveRow("Gender", data.gender)
                .shouldHaveRow("Mobile", data.mobile)
                .shouldHaveRow("Date of Birth", data.expectedDateOfBirth)
                .shouldHaveRow("Subjects", data.expectedSubjects)
                .shouldHaveRow("Hobbies", data.expectedHobbies)
                .shouldHaveRow("Picture", data.picture)
                .shouldHaveRow("Address", data.currentAddress)
                .shouldHaveRow("State and City", data.expectedStateAndCity)
                .close();
    }

    @Test
    void fillPracticeFormMinRequired() {

        form.openPage()
                .removeAdsOnPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .selectGender(data.gender)
                .setMobile(data.mobile)
                .submit();

        modal.shouldAppear()
                .shouldHaveRow("Name", data.fullName)
                .shouldHaveRow("Gender", data.gender)
                .shouldHaveRow("Mobile", data.mobile)
                .close();
    }

    @Test
    void fillPracticeFormNegativeInvalidEmail() {

        String invalidEmail = "not-an-email";

        form.openPage()
                .removeAdsOnPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(invalidEmail)
                .selectGender(data.gender)
                .setMobile(data.mobile)
                .submitExpectingValidation();

        modal.shouldNotAppear();

        com.codeborne.selenide.Selenide.$("#userEmail")
                .shouldHave(com.codeborne.selenide.Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }
}