package util;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsUtils {

    public static void removeAds() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
    }
}