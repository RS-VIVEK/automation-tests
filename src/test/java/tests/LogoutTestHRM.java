package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LogoutHRM;

public class LogoutTestHRM extends BaseClass {

    @Test
    public void testValidLogoutHRM() {
        LogoutHRM logoutHRM = new LogoutHRM(driver, Integer.parseInt(configReader.getProperty("timeout")));
        logoutHRM.enterEmail(configReader.getProperty("email"));
        logoutHRM.enterPassword(configReader.getProperty("password"));
        logoutHRM.loginButton();
        logoutHRM.profileTabBtn();
        logoutHRM.signoutTab();


    }
}
