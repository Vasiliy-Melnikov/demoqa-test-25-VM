import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
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
        $("#uploadPicture").uploadFromClasspath("mycat.jpg");
        $("#currentAddress").setValue("123 Magistr Street, Apt 99, Tambov, RU");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").should(appear);

        $(".modal-content").shouldHave(text("Vasiliy Melnikov"));
        $(".modal-content").shouldHave(text("Vasyliy@gmail.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9987654321"));
        $(".modal-content").shouldHave(text("19 November,1993"));
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Computer Science"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("Reading"));
        $(".modal-content").shouldHave(text("Music"));
        $(".modal-content").shouldHave(text("mycat.jpg"));
        $(".modal-content").shouldHave(text("123 Magistr Street"));
        $(".modal-content").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }
}