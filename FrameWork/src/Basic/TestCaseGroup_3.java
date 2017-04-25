package Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestCaseGroup_3 {
	
	@Test(groups = { "UserAccess" })
	public void Login() {
		System.out.println("Login TestCase");
	}
	
	@Test(groups = { "UserAccess" })
	public void Register() {
		System.out.println("Register TestCase");
	}
	
	@Test(groups = { "AfterValidation" })
	public void Home() {
		System.out.println("Home TestCase");
	}
	
	@Test(groups = { "AfterValidation" })
	public void AboutUs() {
		System.out.println("AboutUs TestCase");
	}
	
	@Test (groups = { "UserAccess", "AfterValidation" })
	public void LogOut() {
		System.out.println("LogOut TestCase");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before MEthod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After MEthod");
	}

}
