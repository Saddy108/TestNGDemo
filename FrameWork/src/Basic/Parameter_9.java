package Basic;


import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Parameter_9 {

	@Test
	@Parameters({ "sUsername", "sPassword" })
	public void Login(String sUsername, String sPassword) {
		System.out.println("Login Started :- "+sUsername + " " +sPassword);
	}

}