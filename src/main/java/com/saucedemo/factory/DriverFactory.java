package com.saucedemo.factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver initDriver(String browser)
    {
        switch(browser.toLowerCase().trim())
        {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        return driver;
    }
    public static WebDriver getDriver()
    {
        return driver;
    }
}
