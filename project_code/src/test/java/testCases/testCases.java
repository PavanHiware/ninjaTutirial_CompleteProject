package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.XLutility;
import utilities.commonUtils;
import utilities.customer_loginDetails;
import utilities.customer_registrationDetails;
import utilities.exelUtility;
import utilities.proportiesFileLoader;

@Listeners(extentReportManager.class)
public class testCases extends baseClass {
	proportiesFileLoader requiredPara = new proportiesFileLoader();
	

	@Test(groups = {"register"})
	public void testCase01() throws IOException, SQLException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));

		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().enterFirstName(excelUtility.inputUserData("New User", "First Name"));
		pageObjectManager.getRegistrationPage().enterLastName(excelUtility.inputUserData("New User", "Last Name"));
		pageObjectManager.getRegistrationPage().enterEmail(excelUtility.inputUserData("New User", "Email ID"));
		pageObjectManager.getRegistrationPage().enterPhoneNumber(excelUtility.inputUserData("New User", "Contact no"));
		pageObjectManager.getRegistrationPage().enterPasswordAndVerify(excelUtility.inputUserData("New User", "Password"));
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
		
	}

	@Test(groups = {"register"})
	public void testCase05() throws IOException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().enterFirstName(excelUtility.inputUserData("New Userr", "First Name"));
		pageObjectManager.getRegistrationPage().enterLastName(excelUtility.inputUserData("New Userr", "Last Name"));
		pageObjectManager.getRegistrationPage().enterEmail(excelUtility.inputUserData("New Userr", "Email ID"));
		pageObjectManager.getRegistrationPage().enterPhoneNumber(excelUtility.inputUserData("New Userr", "Contact No"));
		pageObjectManager.getRegistrationPage().enterPasswordAndVerify(excelUtility.inputUserData("New Userr", "Password"));
		pageObjectManager.getRegistrationPage().clickYesToSubscribe();
		pageObjectManager.getRegistrationPage().checkPrivacyPolicy();
		pageObjectManager.getRegistrationPage().clickContinueAndVerify();
		pageObjectManager.getRegistrationPage().confirmAndContinue();
		pageObjectManager.getCustomerAccountPage().validateSubscription();

	}

	@Test(groups = {"register"})
	public void testCase06() throws IOException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickRegisterAccount();
		pageObjectManager.getRegistrationPage().enterFirstName(excelUtility.inputUserData("New Userrr", "First Name"));
		pageObjectManager.getRegistrationPage().enterLastName(excelUtility.inputUserData("New Userrr", "Last Name"));
		pageObjectManager.getRegistrationPage().enterEmail(excelUtility.inputUserData("New Userrr", "Email"));
		pageObjectManager.getRegistrationPage().enterPhoneNumber(excelUtility.inputUserData("New Userrr", "Contact No"));
		pageObjectManager.getRegistrationPage().enterPasswordAndVerify(excelUtility.inputUserData("New Userrr", "Password"));
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
	public void login_testCase01() throws IOException, SQLException {
//		customer_loginDetails customer =
//		        sqldata.fetchData(requiredPara.getProporty("validCredential_query"));
//		System.out.println("POJO class outpu emailID: "+customer.getEmailID());
//		System.out.println("POJO class output password: "+customer.getPassword());
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		
		openApplication("tutorialNinjaApplication");
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);
	}

	@Test(groups = { "login" })
	public void login_testCase02() throws IOException, SQLException {
//		customer_loginDetails customer =
//		        sqldata.fetchData(requiredPara.getProporty("invalidCredential_query"));
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		openApplication("tutorialNinjaApplication");
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin( excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
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
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		
		 pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
	}

	@Test(groups = { "login" })
	public void login_testCase16() throws IOException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Password");
		pageObjectManager.getChangePasswordPage().changePassword_enterNewPassword(excelUtility.inputUserData("Valid User", "New Password"));
		pageObjectManager.getChangePasswordPage().changePassword_confirmNewPassword(excelUtility.inputUserData("Valid User", "New Password"));
		pageObjectManager.getChangePasswordPage().clickContinue_passwordChange();
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "New Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
		Assert.assertEquals(pageObjectManager.getCustomerAccountPage().validateAccountPage(), true);

	}

	@Test(groups = { "logout" })
	public void logout_testCase01() throws IOException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getCustomerAccountPage().clickLogoutButton();
		pageObjectManager.getLogoutPage().clickContinue();

	}

	@Test(groups = { "logout" })
	public void logout_testCase02() throws IOException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
		pageObjectManager.getLogoutPage().clickContinue();

	}

	@Test(groups = { "logout" })
	public void logout_testCase03() throws IOException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
//		closeBroser();
		openApplication("tutorialNinjaApplication");

	}

	@Test(groups = { "logout" })
	public void logout_testCase04() throws IOException {
		XLutility excelUtility = new XLutility(requiredPara.getProporty("testDataSheet_Path"));
		commonUtils util = new commonUtils(driver);
		pageObjectManager.getHomepage().clickMyAccount();
		pageObjectManager.getHomepage().clickLogin();
		pageObjectManager.getLoginPage().enterEmailLogin(excelUtility.inputUserData("Valid User", "Email ID"));
		pageObjectManager.getLoginPage().enterPasswordLogin(excelUtility.inputUserData("Valid User", "Password"));
		pageObjectManager.getLoginPage().clickLoginButton();
		pageObjectManager.getRegistrationPage().selectLink_from_dropMenu("Logout");
		util.navigateTo("back");

	}
	


}
