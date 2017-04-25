package Basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider11 {
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() throws Exception {
		
		Object[][] testObjArray = ExcelUtils.getTableArray("D:\\Users\\sadgupta\\Desktop\\Java\\Frame\\FrameWork\\test-data\\Data.xlsx",
				"Credential");

		return (testObjArray);
	}

	@Test(dataProvider = "Authentication")
	public void Login(String userID, String passID) {
		System.out.println("Login is Called :- "+userID +" "+passID);
	}
}
