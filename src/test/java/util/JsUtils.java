package util;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsUtils {

    public static void removeAds() {
        executeJavaScript("document.querySelector('footer')?.remove();");
        executeJavaScript("document.querySelector('#fixedban')?.remove();");
        executeJavaScript("document.querySelectorAll('iframe').forEach(el => el.remove());");
    }
}