package Listeners;

import Utils.LogsUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ITestListener  implements org.testng.ITestListener  {

    public void onTestStart(ITestResult result) {
        LogsUtils.info("Starting test case: " + result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
            LogsUtils.info("Test case passed: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        LogsUtils.error("Test case failed: " + result.getMethod().getMethodName());
    }

    public void onStart(ITestContext context) {
        LogsUtils.info("Starting test suite: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        LogsUtils.info("Finishing test suite: " + context.getName());
    }



}
