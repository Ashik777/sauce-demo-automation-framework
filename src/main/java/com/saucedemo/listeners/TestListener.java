package com.saucedemo.listeners;

import com.saucedemo.utilities.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.reports.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getExtendReports();

    private static Map<String, ExtentTest> testMap = new HashMap<>();

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getName();

        if (!testMap.containsKey(testName)) {
            ExtentTest test = extent.createTest(testName);
            testMap.put(testName, test);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        testMap.get(result.getName()).pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = testMap.get(result.getName());

        test.fail("Test Failed");
        test.fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(result.getName());

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        testMap.get(result.getName()).skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}