package com.saucedemo.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.reports.ExtentManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getExtendReports();

    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");
        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}