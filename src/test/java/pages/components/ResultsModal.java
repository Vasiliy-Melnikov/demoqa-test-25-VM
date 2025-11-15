package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ResultsModal {
    private final String modal = ".modal-content";

    public ResultsModal shouldAppear() {
        $(modal).should(appear);
        return this;
    }

    public ResultsModal shouldNotAppear() {
        $(modal).shouldNot(appear);
        return this;
    }

    public ResultsModal shouldHaveRow(String key, String expectedValue) {
        $$(".table-responsive tbody tr")
                .findBy(text(key))
                .shouldHave(text(expectedValue));
        return this;
    }

    public void close() {
        $("#closeLargeModal").click();
        $(modal).shouldNot(appear);
    }
}
