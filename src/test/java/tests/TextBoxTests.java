package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    private final TextBoxPage page = new TextBoxPage();
    private final TestData data = new TestData();

    @Test
    void fillTextBoxWithPageObject() {

        page.openPage()
                .removeAdsOnPage()
                .setFullName(data.fullName)
                .setEmail(data.email)
                .setCurrentAddress(data.currentAddress)
                .setPermanentAddress(data.permanentAddress)
                .submit()
                .shouldSeeResult(data.fullName, data.email, data.currentAddress);
    }
}