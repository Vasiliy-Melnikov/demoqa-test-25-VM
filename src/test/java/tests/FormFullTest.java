package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import pages.PracticeFormPage;
import pages.components.ResultsModal;

public class FormFullTest extends TestBase {

    private final PracticeFormPage form = new PracticeFormPage();
    private final ResultsModal modal = new ResultsModal();
    private final TestData data = new TestData();

    @EnabledIfSystemProperty(named = "browser", matches = "chrome")
    @Test
    void fillPracticeFormFull() {
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
}