package com.saucedemo.utilities;

import com.saucedemo.factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
public static String captureScreenshot(String testName)
{
   WebDriver driver= DriverFactory.getDriver();
    TakesScreenshot ts =(TakesScreenshot) driver;
    File source=ts.getScreenshotAs(OutputType.FILE);
    File folder= new File("Screenshots");
    if(!folder.exists())
    {
        folder.mkdir();
    }
    String path="screenshot/" +testName+ ".png";
    File destination = new File(path);
    try
    {
        FileUtils.copyFile(source,destination);
    } catch (IOException e) {
        e.printStackTrace();
    }

return path;
}
}
