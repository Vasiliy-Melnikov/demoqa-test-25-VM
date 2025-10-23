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
        Configuration.timeout = 10000;
    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        executeJavaScript("document.querySelector('#fixedban')?.remove()");
        executeJavaScript("document.querySelector('footer')?.remove()");
        $("#firstName").setValue("Vasiliy");
        $("#lastName").setValue("Melnikov");
        $("#userEmail").setValue("Vasyliy@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9987654321");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click(); // 19 November 1993
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        File img = new File("src/test/java/resources/mycat.jpg");
        $("#uploadPicture").uploadFile(img);
        $("#currentAddress").setValue("123 Magistr Street, Apt 99, Tambov, RU");
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").scrollIntoView(true).click();
        $(".modal-content").shouldHave(
                text("Vasiliy Melnikov"),
                text("Vasyliy@gmail.com"),
                text("Male"),
                text("9987654321"),
                text("19 November,1993"),
                text("Maths"),
                text("Computer Science"),
                text("Sports"),
                text("Reading"),
                text("Music"),
                text("mycat.jpg"),
                text("123 Magistr Street"),
                text("NCR Delhi")
        );
        $("#closeLargeModal").click();
    }
}