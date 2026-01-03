package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.commonUtils;
import utilities.customerDetails;
import utilities.proportiesFileLoader;
import utilities.sql_dataBase_dataLoader;

@Listeners(extentReportManager.class)
public class testCases extends baseClass {
	proportiesFileLoader requiredPara = new proportiesFileLoader();

	@Test(groups = {"register"})
	public void testCase01() throws IOException {

		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().enterFirstName("firstName");
		pageObjectManager.getRegistrationPage().enterLastName("lastName");
		pageObjectManager.getRegistrationPage().enterEmail("emailID");
		pageObjectManager.getRegistrationPage().enterPhoneNumber("contactNo");
		pageObjectManager.getRegistrationPage().enterPasswordAndVerify("password");
		pageObjectManager.getRegistrationPage().checkPrivacyPolicy();
		pageObjectManager.getRegistrationPage().clickContinueAndVerify();
		pageObjectManager.getRegistrationPage().confirmAndContinue();

		pageObjectManager.getCustomerAccountPage().validateAccountPage();

	}

	@Test(groups = {"register"})
	public void testCase04() throws IOException, SQLException {

		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().clickContinueAndVerify();

		Assert.assertEquals(pageObjectManager.getRegistrationPage().alertMessageprivacyPolicy(),
				"Warning: You must agree to the Privacy Policy!");
		Assert.assertEquals(pageObjectManager.getRegistrationPage().errorMessage_firstName(),
				"First Name must be between 1 and 32 characters!");
		Assert.assertEquals(pageObjectManager.getRegistrationPage().errorMessage_lastName(),
				"Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(pageObjectManager.getRegistrationPage().errorMessage_email(),
				"E-Mail Address does not appear to be valid!");
		Assert.assertEquals(pageObjectManager.getRegistrationPage().errorMessage_telephone(),
				"Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(pageObjectManager.getRegistrationPage().errorMessage_password(),
				"Password must be between 4 and 20 characters!");
		
//		sqldata.fetchData(requiredPara.getProporty("validCredential_query"));
//		customerDetails customer = new customerDetails();
		customerDetails customer =
		        sqldata.fetchData(requiredPara.getProporty("validCredential_query"));
		System.out.println("POJO class outpu firstName: "+customer.getFirstName());
		System.out.println("POJO class output mobile No: "+customer.getContactNo());
	}

	@Test(groups = {"register"})
	public void testCase05() throws IOException {
		
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().enterFirstName("firstName");
		pageObjectManager.getRegistrationPage().enterLastName("lastName");
		pageObjectManager.getRegistrationPage().enterEmail("newEmailID");
		pageObjectManager.getRegistrationPage().enterPhoneNumber("contactNo");
		pageObjectManager.getRegistrationPage().enterPasswordAndVerify("password");
		pageObjectManager.getRegistrationPage().clickYesToSubscribe();
		pageObjectManager.getRegistrationPage().checkPrivacyPolicy();
		pageObjectManager.getRegistrationPage().clickContinueAndVerify();
		pageObjectManager.getRegistrationPage().confirmAndContinue();
		pageObjectManager.getCustomerAccountPage().validateSubscription();

	}

	@Test(groups = {"register"})
	public void testCase06() throws IOException {
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().enterFirstName("firstName");
		pageObjectManager.getRegistrationPage().enterLastName("lastName");
		pageObjectManager.getRegistrationPage().enterEmail("newEmailID");
		pageObjectManager.getRegistrationPage().enterPhoneNumber("contactNo");
		pageObjectManager.getRegistrationPage().enterPasswordAndVerify("password");
		pageObjectManager.getRegistrationPage().clickYesToSubscribe();
		pageObjectManager.getRegistrationPage().checkPrivacyPolicy();
		pageObjectManager.getRegistrationPage().clickContinueAndVerify();
		pageObjectManager.getRegistrationPage().confirmAndContinue();
		pageObjectManager.getCustomerAccountPage().validateSubscription();

	}

	@Test(groups = { "register" })
	public void testCase07() throws IOException {
		
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("My Account");
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Login");
		pageObjectManager.getLoginPage().clickContinue_registerAccount();
		

	}

	@Test(groups = { "login" })
	public void login_testCase01() throws IOException {
		openApplication("tutorialNinjaApplication");
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("valid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);
	}

	@Test(groups = { "login" })
	public void login_testCase02() throws IOException {
		openApplication("tutorialNinjaApplication");
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("invalid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getLoginPage().alertMessage_noMatchFound(),
				"Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(groups = { "login" })
	public void login_testCase05() throws IOException {
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(" ");
		pageObjectManager.getLoginPage().enterPasswordLogin(" ");
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getLoginPage().alertMessage_noMatchFound(),
				"Warning: No match for E-Mail Address and/or Password.");

	}

	@Test(groups = { "login" })
	public void login_testCase06() throws IOException {
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().clickOnForgotPassword();
	}

	@Test(groups = { "login" })
	public void login_testCase10() throws IOException {
		
		
		 pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("valid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
	}

	@Test(groups = { "login" })
	public void login_testCase16() throws IOException {
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("valid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Password");
		pageObjectManager.getChangePasswordPage().changePassword_enterNewPassword();
		pageObjectManager.getChangePasswordPage().changePassword_confirmNewPassword();
		pageObjectManager.getChangePasswordPage().clickContinue_passwordChange();
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("password change");
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);

	}

	@Test(groups = { "logout" })
	public void logout_testCase01() throws IOException {
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("valid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getCustomerAccountPage().clickLogoutButton();
		pageObjectManager.getLogoutPage().clickContinue();

	}

	@Test(groups = { "logout" })
	public void logout_testCase02() throws IOException {
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("valid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
		pageObjectManager.getLogoutPage().clickContinue();

	}

	@Test(groups = { "logout" })
	public void logout_testCase03() throws IOException {
		
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("valid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
//		closeBroser();
		openApplication("tutorialNinjaApplication");

	}

	@Test(groups = { "logout" })
	public void logout_testCase04() throws IOException {
		commonUtils util = new commonUtils(driver);
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin("valid credential");
		pageObjectManager.getLoginPage().enterPasswordLogin("valid credential");
		pageObjectManager.getLoginPage().clickLoginButton();
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
		util.navigateTo("back");

	}

}
