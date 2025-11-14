package components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ResultsModal {
    // корень модалки
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
        // ищем строку таблицы по названию поля (левый столбец)
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
