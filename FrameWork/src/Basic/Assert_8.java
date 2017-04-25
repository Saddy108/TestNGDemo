package Basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assert_8 {

	boolean isLogin = false;
	boolean isHome = false;
	String UserName = "Sadanand";

	@Test(priority = 0)
	public void Login() {
		System.out.println("Login is Called");
		Assert.assertTrue(isLogin);
		System.out.println("Login is Executed");
	}

	@Test(priority = 1)
	public void Home() {
		System.out.println("Home is Called");
		Assert.assertFalse(isHome);
		System.out.println("Home is Executed");
	}

	@Test(priority = 2)
	public void CheckUser() {
		System.out.println("Home is Called");
		Assert.assertEquals("Shikha", UserName);
		System.out.println("Home is Executed");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

}
