package testCases;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportManager extends baseClass implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public static WebDriver listenerDriver;

	@Override
	public void onStart(ITestContext context) {

//		if (baseClass.getDriver() == null) {
//			baseClass.driver = new ChromeDriver();
//			baseClass.driver.manage().window().maximize();
//		}

		

		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_");
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/reports/" + fileName + "_testExecution_extentReport.html");

		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Tester Name", "Pavan Hiware");

	}

	

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case is passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case is failed: " + result.getName());
		test.log(Status.FAIL, "Test case is FAILED cused is: " + result.getThrowable());
		Object testInstance = result.getInstance();

		String ssPath = null;
		try {
			System.out.println("Value of driver in listener: " + getDriver());
			if (getDriver() != null && ((RemoteWebDriver) getDriver()).getSessionId() != null) {

				ssPath = captureScreenshot();
			} else {
				System.out.println("Driver is null in listner");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(Status.FAIL, "Please find below screenshot: " + test.addScreenCaptureFromPath(ssPath));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case is skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
