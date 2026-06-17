package com.saucedemo.tests;

import com.saucedemo.listeners.RetryAnalyzer;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer=RetryAnalyzer.class)
    public void verifyValidLogin()  {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce"
        );

        Assert.assertEquals(
                driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}