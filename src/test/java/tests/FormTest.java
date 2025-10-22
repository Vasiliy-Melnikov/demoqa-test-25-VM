package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");

        // Close ad/footer if present
        executeJavaScript("document.querySelector('#fixedban')?.remove()");
        executeJavaScript("document.querySelector('footer')?.remove()");

        // 1. Text inputs
        $("#firstName").setValue("Basil");
        $("#lastName").setValue("Melnikov");
        $("#userEmail").setValue("basil@example.com");

        // 2. Gender (radio)
        $(byText("Male")).click();

        // 3. Mobile
        $("#userNumber").setValue("9123456789");

        // 4. Date of Birth (use the datepicker)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click(); // 15 June 1995

        // 5. Subjects (autocomplete)
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        // 6. Hobbies (checkboxes)
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        // 7. Picture upload (from resources)
        File img = new File("src/test/resources/avatar.png");
        $("#uploadPicture").uploadFile(img);

        // 8. Current Address (textarea)
        $("#currentAddress").setValue("123 Test Street, Apt 4, San Francisco, CA");

        // 9. State and City (react-select)
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        // 10. Submit
        $("#submit").scrollIntoView(true).click();

        // 11. Verify modal content
        $(".modal-content").shouldHave(
                text("Basil Melnikov"),
                text("basil@example.com"),
                text("Male"),
                text("9123456789"),
                text("15 June,1995"),
                text("Maths"),
                text("Computer Science"),
                text("Sports"),
                text("Reading"),
                text("Music"),
                text("avatar.png"),
                text("123 Test Street"),
                text("NCR Delhi")
        );

        // Close modal
        $("#closeLargeModal").click();
    }
}