package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.WaitHelper;

public class LoginPageGmail {
    WebDriver driver;
    WaitHelper wait;

    private By emailField = By.xpath("//input[@id='identifierId']");
    private By nextBtn = By.xpath("//span[text()='Next']");
    private By passField = By.xpath("//input[@name='Passwd']");
    private By profileIcon = By.xpath("//a[@class='gb_B gb_0a gb_1']");


 //   private By signoutBtn = By.xpath("//div[text()='Sign out']");

    public LoginPageGmail(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, timeout);
    }

    public void enterEmail(String email) {
        wait.waitForVisibility(emailField).sendKeys(email);
        wait.waitForVisibility(nextBtn).click();
    }

    public void enterPassword(String password) {
        wait.waitForVisibility(passField).sendKeys(password);
        wait.waitForVisibility(nextBtn).click();
    }

    public void profileTab() {
        wait.waitForVisibility(profileIcon).click();
    }
}
