package com.brite.tests.components.login;

import com.brite.pages.login.LoginPage;
import com.brite.utilities.BriteUtils;
import com.brite.utilities.ConfigurationReader;
import com.brite.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginTest1(){
        extentLogger = report.createTest("Login as a store manager");
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        //extentLogger.info("Clicking on remember me");
        //loginPage.clickRememberMe();
        loginPage.login(username, password);
        //to verify that Discuss/#inbox page opened
        //Once page name Discuss displays, means that we have logged in successfully
        Assert.assertEquals(BriteUtils.getPageSubTitle(), "#Inbox");
        extentLogger.pass("Verified that page name is #Inbox");
    }

    @Test
    public void negativeLoginTest1(){
        extentLogger = report.createTest("Login with invalid credentials");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Logging with username wrongusername and password wrongpassword");
        loginPage.login("wrongusername", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Wrong login/password");
        extentLogger.pass("Verified that warning message displayed: Wrong login/password");
    }


}
