package Advance;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class TakeScreenShot {

	static WebDriver driver = null;
	String UserName = "Sadanand";
	
	public static void takeSnapShot(WebDriver webdriver) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		String	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("Sadanand "+timeStamp);
		File DestFile = new File("D:\\"+timeStamp+".png");
		System.out.println("Sadanand "+DestFile.toString());
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
//		String filePath = DestFile.toString();
//		String path = "<img src=\"file://"+filePath+"\"  />";
		Reporter.log("Sadanand");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
//		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.ie.driver", "d://IEDriverServer.exe");
//	driver = new InternetExplorerDriver();
//		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
	//	driver.manage().window().maximize();
		
		driver.findElement(By.name("userName")).sendKeys("Saddy@Cg.com");
		driver.findElement(By.name("password")).sendKeys("Password");
		driver.findElement(By.name("login")).click();
		System.out.println("Login");
		
		try {
			takeSnapShot(driver);
			System.out.println("ScreenShot");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
