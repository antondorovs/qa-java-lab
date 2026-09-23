package io.github.antondorovs.qa.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.antondorovs.qa.config.TestConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("ui")
public abstract class BaseUiTest {
    @BeforeEach
    void configureBrowser() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.baseUrl = TestConfig.get("ui.baseUrl", "UI_BASE_URL");
        Configuration.browser = TestConfig.get("browser", "BROWSER");
        Configuration.headless = TestConfig.headless();
        Configuration.timeout = TestConfig.uiTimeout();
        Configuration.pageLoadTimeout = 30000;
        Configuration.browserSize = "1440x1000";
        Configuration.reportsFolder = "build/selenide";
        String remote = TestConfig.get("selenide.remote", "SELENIDE_REMOTE");
        Configuration.remote = remote.isBlank() ? null : remote;
        if (Configuration.browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", Map.of(
                    "credentials_enable_service", false,
                    "profile.password_manager_enabled", false,
                    "profile.password_manager_leak_detection", false));
            Configuration.browserCapabilities = options;
        }
    }

    @AfterEach
    void closeBrowser() {
        try {
            closeWebDriver();
        } finally {
            SelenideLogger.removeListener("allure");
        }
    }
}
