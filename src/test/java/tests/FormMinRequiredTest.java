package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultsModal;

public class FormMinRequiredTest extends TestBase {

    private final PracticeFormPage form = new PracticeFormPage();
    private final ResultsModal modal = new ResultsModal();
    private final TestData data = new TestData();

    @Test
    void fillPracticeFormMinRequired() {
        form.openPage()
                .removeAdsOnPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .selectGender(data.gender)
                .setMobile(data.mobile)
                .submit();

        modal.shouldAppear()
                .shouldHaveRow("Name", data.fullName)
                .shouldHaveRow("Gender", data.gender)
                .shouldHaveRow("Mobile", data.mobile)
                .close();
    }
}