package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
        @Test
        void fillFormTest() {
            open("/text-box");
            $("#userName").setValue("123");
            $("#userEmail").setValue("123@mail.com");
            $("#currentAddress").setValue("some 3");
            $("#permanentAddress").setValue("some 4");
            $("submit").click();

            $("#output #name").shouldHave(text("123"));
            $("#output #email").shouldHave(text("123@mail.com"));
            $("#output #currentAddress").shouldHave(text("some 3"));
            $("#output #permanentAddress").shouldHave(text("some 4"));
        }
    }
