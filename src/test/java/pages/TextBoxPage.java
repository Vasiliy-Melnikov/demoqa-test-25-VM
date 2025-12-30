package pages;

import com.codeborne.selenide.SelenideElement;
import util.JsUtils;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TextBoxPage {

    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputBlock = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setFullName(String v) {
        fullNameInput.setValue(v);
        return this;
    }

    public TextBoxPage setEmail(String v) {
        emailInput.setValue(v);
        return this;
    }

    public TextBoxPage setCurrentAddress(String v) {
        currentAddressInput.setValue(v);
        return this;
    }

    public TextBoxPage setPermanentAddress(String v) {
        permanentAddressInput.setValue(v);
        return this;
    }

    public TextBoxPage removeAdsOnPage() {
        JsUtils.removeAds();
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage shouldSeeResult(String... fragments) {
        outputBlock.shouldBe(visible);
        for (String f : fragments) {
            outputBlock.shouldHave(text(f));
        }
        return this;
    }
}