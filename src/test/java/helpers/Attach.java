package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {

    @Attachment(value = "{attachName}", type = "image/png", fileExtension = "png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html", fileExtension = "html")
    public static byte[] pageSource() {
        return WebDriverRunner.getWebDriver()
                .getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Browser console logs", type = "text/plain", fileExtension = "txt")
    public static String consoleLogs() {
        return String.join("\n", getWebDriverLogs(BROWSER));
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = "html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay>" +
                "<source src='" + getVideoUrl() + "' type='video/mp4'>" +
                "</video></body></html>";
    }

    public static String getVideoUrl() {
        String videoStorage = System.getProperty("videoStorage",
                "https://selenoid.autotests.cloud/video/");
        String sessionId = ((RemoteWebDriver) WebDriverRunner.getWebDriver())
                .getSessionId().toString();
        return videoStorage + sessionId + ".mp4";
    }
}