package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Selenide.$;

public class FormTest extends TestBase {
    private final PracticeFormPage form = new PracticeFormPage();
    private final ResultsModal modal = new ResultsModal();

    @Test
    void fillPracticeFormTest() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;

        String email = faker.internet().emailAddress();
        String gender = "Male";
        String mobile = faker.phoneNumber().subscriberNumber(10);

        String birthMonth = "November";
        String birthYear = "1993";
        String birthDay = "19";
        String expectedDateOfBirth = birthDay + " " + birthMonth + "," + birthYear;

        String subject1 = "Maths";
        String subject2 = "Computer Science";
        String expectedSubjects = subject1 + ", " + subject2;

        String hobby1 = "Sports";
        String hobby2 = "Reading";
        String hobby3 = "Music";
        String expectedHobbies = hobby1 + ", " + hobby2 + ", " + hobby3;

        String picture = "mycat.jpg";
        String address = faker.address().fullAddress();
        String state = "NCR";
        String city = "Delhi";
        String expectedStateAndCity = state + " " + city;
        form.openPage()
                .removeAdsOnPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setMobile(mobile)
                .setBirthDate(birthMonth, birthYear, birthDay)
                .addSubject(subject1)
                .addSubject(subject2)
                .selectHobby(hobby1)
                .selectHobby(hobby2)
                .selectHobby(hobby3)
                .uploadPictureFromClasspath(picture)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .submit();

        modal.shouldAppear()
                .shouldHaveRow("Student Name", fullName)
                .shouldHaveRow("Student Email", email)
                .shouldHaveRow("Gender", gender)
                .shouldHaveRow("Mobile", mobile)
                .shouldHaveRow("Date of Birth", expectedDateOfBirth)
                .shouldHaveRow("Subjects", expectedSubjects)
                .shouldHaveRow("Hobbies", expectedHobbies)
                .shouldHaveRow("Picture", picture)
                .shouldHaveRow("Address", address)
                .shouldHaveRow("State and City", expectedStateAndCity)
                .close();
    }

    @Test
    void fillPracticeFormMinRequired() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;

        String gender = "Male";
        String mobile = faker.phoneNumber().subscriberNumber(10);

        form.openPage()
                .removeAdsOnPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .selectGender(gender)
                .setMobile(mobile)
                .submit();

        modal.shouldAppear()
                .shouldHaveRow("Student Name", fullName)
                .shouldHaveRow("Gender", gender)
                .shouldHaveRow("Mobile", mobile)
                .close();
    }

    @Test
    void fillPracticeFormNegativeInvalidEmail() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = "Male";
        String mobile = faker.phoneNumber().subscriberNumber(10);
        String invalidEmail = "not-an-email";

        form.openPage()
                .removeAdsOnPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(invalidEmail)
                .selectGender(gender)
                .setMobile(mobile)
                .submitExpectingValidation();


        modal.shouldNotAppear();

        $("#userEmail").shouldHave(com.codeborne.selenide.Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
