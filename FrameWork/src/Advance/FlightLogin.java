package Advance;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Listeners(Advance.Listener.class)
public class FlightLogin {
	
	static WebDriver driver = null;
	String UserName = "Sadanand";
	
	@Test
	public void Login() {
		System.out.println("Login Method");
		driver.findElement(By.name("userName")).sendKeys("Saddy@Cg.com");
		driver.findElement(By.name("password")).sendKeys("Password");
		driver.findElement(By.name("login")).click();
		Assert.assertEquals("Shikha", UserName);
	}

	@BeforeMethod
	public void OpenBrowser() {
		System.out.println("Before Method");
		//System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void CloseBrowser() {
		System.out.println("After Method");
		//driver.quit();
	}

}
