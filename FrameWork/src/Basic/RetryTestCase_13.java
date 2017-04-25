package Basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTestCase_13 {
	
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

	@Test(retryAnalyzer = Basic.RetryAnalyzer.class)
	public void CheckUser() {
		System.out.println("Home is Called");
		Assert.assertEquals("Shikha", UserName);
		System.out.println("Home is Executed");
	}
}
