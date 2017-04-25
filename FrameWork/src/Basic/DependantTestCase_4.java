package Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class DependantTestCase_4 {
	
	@Test(dependsOnMethods = { "OpenBrowser" })
	public void SignIn() {
		System.out.println("This will execute second (SignIn)");
	}

	@Test
	public void OpenBrowser() {
		System.out.println("This will execute first (Open Browser)");
	}

	@Test(dependsOnMethods = { "SignIn" })
	public void LogOut() {
		System.out.println("This will execute third (Log Out)");
	}

}
