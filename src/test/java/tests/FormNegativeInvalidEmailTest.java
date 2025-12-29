package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.cssValue;

public class FormNegativeInvalidEmailTest extends TestBase {

    private final PracticeFormPage form = new PracticeFormPage();
    private final ResultsModal modal = new ResultsModal();
    private final TestData data = new TestData();

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

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}