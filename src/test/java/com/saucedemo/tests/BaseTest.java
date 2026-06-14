package com.saucedemo.tests;

import com.saucedemo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {

        driver = DriverFactory.initDriver(browser);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}

