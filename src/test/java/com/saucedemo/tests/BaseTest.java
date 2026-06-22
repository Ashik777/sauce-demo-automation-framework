package com.saucedemo.tests;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {

        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}

