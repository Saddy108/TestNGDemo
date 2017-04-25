package Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Reporter;

public class LoggingTestCase_7 {
	
	@Test(priority = 0)
	public void One() {
		Reporter.log("TestCase One is Started\n");
		System.out.println("This is the Test Case number One");
		Reporter.log("TestCase One End");
	}

	@Test(priority = 1)
	public void Two() {
		Reporter.log("TestCase Two is Started\n");
		System.out.println("This is the Test Case number Two");
		Reporter.log("TestCase Two End");
	}

	@Test(priority = 2, enabled = false)
	public void Three() {
		Reporter.log("TestCase Three is Started\n");
		System.out.println("This is the Test Case number Three");
		Reporter.log("TestCase Three End");
	}

	@Test(priority = 3)
	public void Four() {
		Reporter.log("TestCase Four is Started\n");
		System.out.println("This is the Test Case number Four");
		Reporter.log("TestCase Four End");
	}

}
