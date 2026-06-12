package com.saucedemo.tests;

import com.saucedemo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}

