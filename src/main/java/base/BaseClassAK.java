package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.ConfigReaderHeroKu;
import util.DriverFactory;


public class BaseClassAK {

    protected WebDriver driver;
    private DriverFactory driverFactory;
    protected ConfigReaderHeroKu configReader;

    @BeforeMethod
    public void setUp() {
        configReader = new ConfigReaderHeroKu();
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver(configReader.getProperty("browser1"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(configReader.getProperty("url1"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}


