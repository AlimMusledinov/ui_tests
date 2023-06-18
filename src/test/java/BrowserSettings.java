import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserSettings {

    public void startBrowser() {

        //Configuration.browser = "edge";
        //Configuration.browser="firefox";
        WebDriverManager.chromedriver().driverVersion("85").setup();
        System.setProperty("chromeoptions.args", "--no-sandbox");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Al2\\IdeaProjects\\ui_tests\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("selenide.browser","chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("selenide.browser", "chrome");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-data-dir=~/.config/google-chrome");


        options.setExperimentalOption("useAutomationExtension", false);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.timeout = 6000;
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

}
