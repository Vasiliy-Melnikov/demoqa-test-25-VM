package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    private final TextBoxPage page = new TextBoxPage();

    @Test
    void fillTextBoxWithPageObject() {
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().streetAddress();

        page.openPage()
                .removeAdsOnPage()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .shouldSeeResult(fullName, email, currentAddress);
    }
}