package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    private final TextBoxPage page = new TextBoxPage();

    @Test
    void fillTextBoxWithPageObject() {
        page.openPage()
                .removeAdsOnPage()
                .setFullName("Vasiliy Melnikov")
                .setEmail("vasyliy@gmail.com")
                .setCurrentAddress("Tambov, RU")
                .setPermanentAddress("Tambov, RU")
                .submit()
                .shouldSeeResult("Vasiliy Melnikov", "vasyliy@gmail.com", "Tambov");
    }
}