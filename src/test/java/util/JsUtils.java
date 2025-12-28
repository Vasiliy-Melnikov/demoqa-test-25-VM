package util;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsUtils {

    public static void removeAds() {
        executeJavaScript("var f = document.querySelector('footer'); if (f) f.remove();");
        executeJavaScript("var b = document.querySelector('#fixedban'); if (b) b.remove();");
        executeJavaScript(
                "document.querySelectorAll('iframe').forEach(function(el){ el.remove(); });"
        );
    }
}