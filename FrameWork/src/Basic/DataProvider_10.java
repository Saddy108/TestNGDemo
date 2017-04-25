package Basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_10 {

	
	@DataProvider(name = "Authentication")
	
	public static Object[][] credentials() {
		
		return new Object[][] { { "", "" ,"" }, { "kat", "rina" ,"kaif" } };
	}

	
	
	@Test(dataProvider = "Authentication")
	public void Login(String userID, String passID , String surname) {
		System.out.println("Login is Called :- "+userID +" "+passID+" "+surname);
		
		
	}
	
}
