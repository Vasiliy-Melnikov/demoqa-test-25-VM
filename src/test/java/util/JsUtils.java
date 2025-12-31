package util;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsUtils {

    public static void removeAds() {
        // старое
        executeJavaScript(
                "document.querySelectorAll('footer, #fixedban').forEach(e => e.remove());"
        );

        executeJavaScript(
                "document.querySelectorAll('iframe[id^=\"google_ads_iframe\"]').forEach(function(iframe) {" +
                        "  var container = iframe.closest('table, div, ins');" +
                        "  if (container) {" +
                        "    container.remove();" +
                        "  } else {" +
                        "    iframe.remove();" +
                        "  }" +
                        "});"
        );
        executeJavaScript(
                "var anchor = document.getElementById('adplus-anchor');" +
                        "if (anchor) {" +
                        "  var parent = anchor.parentElement;" +
                        "  if (parent) {" +
                        "    parent.remove();" +
                        "  } else {" +
                        "    anchor.remove();" +
                        "  }" +
                        "}"
        );
    }
}