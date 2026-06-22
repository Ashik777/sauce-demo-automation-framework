package com.saucedemo.tests;

import com.saucedemo.listeners.RetryAnalyzer;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer=RetryAnalyzer.class)
    public void verifyValidLogin()  {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));

        Assert.assertEquals(
                driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}