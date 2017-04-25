package Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotations {
	
	@Test(dataProvider = "Data")
	public void Login(String UserName, String Password) {
		System.out.println("Login is Executed :- "+UserName +" "+Password);
	}
	
	@Test(dataProvider = "Data")
	public void Register(String UserName, String Password) {
		System.out.println("Register is Executed :- "+UserName +" "+Password);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method is Invoked");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method is Invoked");
	}

	@DataProvider
	public Object[][] Data() {
		System.out.println("Data Provider is Invoked");
		return new Object[][] { new Object[] { "Sad", "Anand" }, new Object[] { "Sad", "Anand" }, };
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class is Invoked");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class is Invoked");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test is Invoked");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test is Invoked");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite is Invoked");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite is Invoked");
	}

}
