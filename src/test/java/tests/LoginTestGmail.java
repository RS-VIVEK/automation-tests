package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPageGmail;

public class LoginTestGmail extends BaseClass {

    @Test
    public void testValidLogin() {
        LoginPageGmail loginPageGmail = new LoginPageGmail(driver, Integer.parseInt(configReader.getProperty("timeout")));
        loginPageGmail.enterEmail(configReader.getProperty("email"));
        loginPageGmail.enterPassword(configReader.getProperty("password"));
        loginPageGmail.profileTab();
    }
}
