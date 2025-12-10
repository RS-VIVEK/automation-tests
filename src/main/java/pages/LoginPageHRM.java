package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.WaitHelper;

public class LoginPageHRM {

    WebDriver driver;
    WaitHelper wait;

    private By emailField = By.xpath("//input[@name ='username']");
    private By passField = By.xpath("//input[@name ='password']");
    private By loginBtn = By.xpath("//button[text()=' Login ']");

    public LoginPageHRM(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, timeOut);
    }

    public void enterEmail(String email) {
        wait.waitForVisibility(emailField).sendKeys(email);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterPassword(String password) {
        wait.waitForVisibility(passField).sendKeys(password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void loginButton() {
        wait.waitForVisibility(loginBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

