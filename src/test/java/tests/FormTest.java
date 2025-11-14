package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import components.ResultsModal;

import static com.codeborne.selenide.Selenide.$;

public class FormTest {
    private final PracticeFormPage form = new PracticeFormPage();
    private final ResultsModal modal = new ResultsModal();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeForm_fullData() {
        form.openPage()
                .removeAds()
                .setFirstName("Vasiliy")
                .setLastName("Melnikov")
                .setEmail("Vasyliy@gmail.com")
                .selectGender("Male")
                .setMobile("9987654321")
                .setBirthDate("November", "1993", "19")
                .addSubject("Maths")
                .addSubject("Computer Science")
                .selectHobby("Sports")
                .selectHobby("Reading")
                .selectHobby("Music")
                .uploadPictureFromClasspath("mycat.jpg")
                .setAddress("123 Magistr Street, Apt 99, Tambov, RU")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();

        modal.shouldAppear()
                .shouldHaveRow("Student Name", "Vasiliy Melnikov")
                .shouldHaveRow("Student Email", "Vasyliy@gmail.com")
                .shouldHaveRow("Gender", "Male")
                .shouldHaveRow("Mobile", "9987654321")
                // на demoqa дата рендерится без пробела после запятой
                .shouldHaveRow("Date of Birth", "19 November,1993")
                .shouldHaveRow("Subjects", "Maths, Computer Science")
                .shouldHaveRow("Hobbies", "Sports, Reading, Music")
                .shouldHaveRow("Picture", "mycat.jpg")
                .shouldHaveRow("Address", "123 Magistr Street, Apt 99, Tambov, RU")
                .shouldHaveRow("State and City", "NCR Delhi")
                .close();
    }

    @Test
    void fillPracticeForm_minRequired() {

        form.openPage()
                .removeAds()
                .setFirstName("Vasiliy")
                .setLastName("Melnikov")
                .selectGender("Male")
                .setMobile("9987654321")
                .submit();

        modal.shouldAppear()
                .shouldHaveRow("Student Name", "Vasiliy Melnikov")
                .shouldHaveRow("Gender", "Male")
                .shouldHaveRow("Mobile", "9987654321")
                .close();
    }

    @Test
    void fillPracticeForm_negative_invalidEmail() {
        form.openPage()
                .removeAds()
                .setFirstName("Vasiliy")
                .setLastName("Melnikov")
                .setEmail("not-an-email")
                .selectGender("Male")
                .setMobile("9987654321")
                .submitExpectingValidation();


        modal.shouldNotAppear();

        $("#userEmail").shouldHave(com.codeborne.selenide.Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
