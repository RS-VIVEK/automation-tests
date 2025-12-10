package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver initializeDriver(String browser) {
        WebDriver driver = null;

        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications");
                    driver = new ChromeDriver(options);

                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    System.setProperty("webdriver.edge.driver", "C:/Users/rsvis/Downloads/edgedriver_win64 (1)/msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("Browser not supported : " + browser);
            }
        } catch (Exception e) {
            System.out.println("Failed to initialize driver for browser: " + browser);
            e.printStackTrace();
        }
        return driver;
    }
}
