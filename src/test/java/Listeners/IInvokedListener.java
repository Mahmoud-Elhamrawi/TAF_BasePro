package Listeners;

import Utils.ClassesUtils;
import Utils.LogsUtils;
import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static Factory.FactoryClass.getDriver;

public class IInvokedListener implements IInvokedMethodListener {


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        LogsUtils.info("Before starting test case: " + method.getTestMethod().getMethodName());
    }





    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        LogsUtils.info("After  Invocation");

        if(testResult.getStatus()==ITestResult.FAILURE){
                LogsUtils.error("Test case become failed: " + testResult.getName());
            try {
               ClassesUtils.takeScreenshot(getDriver() ,testResult.getName());
            } catch (IOException e) {
                 LogsUtils.error("Error in taking screenshot"+ e.getMessage());
                 e.getStackTrace();
            }

        }


        // add logs
        try {
            File fileLog = ClassesUtils.getLatestFile(LogsUtils.logsPath);
            Allure.addAttachment("Logs", Files.readString(fileLog.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
