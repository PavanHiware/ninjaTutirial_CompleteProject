package testCases;

import java.io.IOException;

import utilities.XLutility;

public class testTrial {

	public static void main(String[] args) throws IOException {
		
		
			XLutility exelUtility = new XLutility("C:\\Users\\2110883\\OneDrive - Cognizant\\Desktop\\ninjaWeb_Automation\\ninjaTutirial_CompleteProject\\project_code\\src\\main\\resources\\TestDataSheet.xlsx");
			String FirstName =exelUtility.inputUserData("New User", "First Name");
			String LastName =exelUtility.inputUserData("New User", "Last Name");
			String Status =exelUtility.inputUserData("New User", "User Status");
			System.out.println(FirstName);
			System.out.println(LastName);
			System.out.println(Status);
					
		}
	

}
