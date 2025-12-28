package util;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsUtils {

    public static void removeAds() {
        executeJavaScript("document.querySelector('footer') && document.querySelector('footer').remove();");
        executeJavaScript("document.querySelector('#fixedban') && document.querySelector('#fixedban').remove();");
        executeJavaScript(
                "document.querySelectorAll('iframe').forEach(function(el){ el.remove(); });"
        );
    }
}