package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class Browser {

    private ChromeOptions chromeOptions = new ChromeOptions();

    public ChromeOptions getChromeOptions() {
        return chromeOptions;
    }

    public void setChromeOptions(ChromeOptions chromeOptions) {
        this.chromeOptions = chromeOptions;
    }

    public static WebDriver driver;

    public WebDriver chromeDriver() {
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays
                .asList("enable-automation"));
        driver = new ChromeDriver(getChromeOptions());
        return driver;
    }
}