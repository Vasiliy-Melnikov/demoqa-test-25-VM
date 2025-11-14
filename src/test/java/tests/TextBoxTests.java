package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests {
    private final TextBoxPage page = new TextBoxPage();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillTextBox_withPageObject() {
        page.openPage()
                .removeAds()
                .setFullName("Vasiliy Melnikov")
                .setEmail("vasyliy@gmail.com")
                .setCurrentAddress("Tambov, RU")
                .setPermanentAddress("Tambov, RU")
                .submit()
                .shouldSeeResult("Vasiliy Melnikov", "vasyliy@gmail.com", "Tambov");
    }
}