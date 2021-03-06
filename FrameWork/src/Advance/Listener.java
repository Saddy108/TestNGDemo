package Advance;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	String ScreenShotPath = "";
	public static void takeSnapShot(WebDriver webdriver) throws Exception {
		String	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("Sadanand "+timeStamp);
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		
		File DestFile = new File("D:\\"+timeStamp+".png");
		System.out.println("Sadanand "+DestFile.toString());
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
		String filePath = DestFile.toString();
		String path = "<img src=\"file://"+filePath+"\"  />";
		String Apath = "<a href=\"file://"+filePath+"\" target=\"_blank\" > ScreenShot </a>";
		Reporter.log(Apath);
	}

	// This belongs to ISuiteListener and will execute before the Suite start
	@Override
	public void onStart(ISuite arg0) {
		Reporter.log("About to begin executing Suite " + arg0.getName(), true);
	}

	// This belongs to ISuiteListener and will execute, once the Suite is
	// finished
	@Override
	public void onFinish(ISuite arg0) {
		Reporter.log("About to end executing Suite " + arg0.getName(), true);
	}

	// This belongs to ITestListener and will execute before starting of Test
	// set/batch
	public void onStart(ITestContext arg0) {
		Reporter.log("About to begin executing Test " + arg0.getName(), true);
	}

	// This belongs to ITestListener and will execute, once the Test set/batch
	// is finished
	public void onFinish(ITestContext arg0) {
		Reporter.log("Completed executing test " + arg0.getName(), true);
	}

	// This belongs to ITestListener and will execute only when the test is pass
	public void onTestSuccess(ITestResult arg0) {
		// This is calling the printTestResults method
		printTestResults(arg0);
	}

	// This belongs to ITestListener and will execute only on the event of fail
	// test
	public void onTestFailure(ITestResult arg0) {
		// This is calling the printTestResults method
		printTestResults(arg0);
		
	}

	// This belongs to ITestListener and will execute before the main test start
	// (@Test)
	public void onTestStart(ITestResult arg0) {
		System.out.println("The execution of the main test starts now");
	}

	// This belongs to ITestListener and will execute only if any of the main
	// test(@Test) get skipped
	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);
	}

	// This is just a piece of shit, ignore this
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:
			
			try {
				System.out.println("Sadanand "+"Test Failed");
				takeSnapShot(FlightLogin.driver);
				System.out.println("Sadanand "+"After Screen");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}

	// This belongs to IInvokedMethodListener and will execute before every
	// method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This belongs to IInvokedMethodListener and will execute after every
	// method including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

}