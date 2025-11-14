package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TextBoxPage {
    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage removeAds() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public TextBoxPage setFullName(String v) {
        $("#userName").setValue(v);
        return this;
    }

    public TextBoxPage setEmail(String v) {
        $("#userEmail").setValue(v);
        return this;
    }

    public TextBoxPage setCurrentAddress(String v) {
        $("#currentAddress").setValue(v);
        return this;
    }

    public TextBoxPage setPermanentAddress(String v) {
        $("#permanentAddress").setValue(v);
        return this;
    }

    public TextBoxPage submit() {
        $("#submit").click();
        return this;
    }

    public TextBoxPage shouldSeeResult(String... fragments) {
        $("#output").shouldBe(visible);
        for (String f : fragments) {
            $("#output").shouldHave(text(f));
        }
        return this;
    }
}