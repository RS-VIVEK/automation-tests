package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

    private WebDriver driver;
    private JavascriptExecutor js;  //  common object created once

    public JavaScriptUtil(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;  //  cast
    }

    // Scroll to a specific element
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll by pixel //
    public void scrollByPixel(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ");");
    }

    // Scroll to bottom
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll to top
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }
}