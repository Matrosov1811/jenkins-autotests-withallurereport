package pav.matrosov;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    Steps steps = new Steps();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String login = System.getProperty("login");
        String password = System.getProperty("password");
        String url = System.getProperty("url");
        String remoteUrl = "https://" + login + ":" + password + "@" + url;
        String browser = System.getProperty("browser", "chrome");

        Configuration.browser = browser;
        Configuration.remote = remoteUrl;

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}