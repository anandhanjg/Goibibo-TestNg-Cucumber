package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GoibiboListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("ON TEST START");
        System.out.println(result.toString());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("ON TEST SUCCESS");
        System.out.println(result.toString());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("ON TEST FAILURE");
        System.out.println(result.toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("ON TEST SKIPPED");
        System.out.println(result.toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("ON TEST FAILED BUT WITH IN SUCCESS PERCENTAGE");
        System.out.println(result.toString());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("ON TEST FAILED WITH TIMEOUT");
        System.out.println(result.toString());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("ON START");
        System.out.println(context.toString());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("ON FINISH");
        System.out.println(context.toString());
    }
}
