package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {
	public store_homePage homePage;
	public store_loginPage loginPage;
	public store_registerationPage registerationPage;
	public customer_accountHomePage accountHomePage;
	public customer_changePassowrd changePasswordPage;
	public customer_logoutPage logoutPage;
	
	public WebDriver driver;

	public pageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	

	public store_homePage getHomepage() {
		homePage = new store_homePage(driver);
		return homePage;
	}
	public store_registerationPage getRegistrationPage() {
		registerationPage = new store_registerationPage(driver);
		return registerationPage;
	}
	public customer_accountHomePage getCustomerAccountPage() {
		 accountHomePage = new customer_accountHomePage(driver);
		return accountHomePage;
	}
	public store_loginPage getLoginPage() {
		loginPage = new store_loginPage(driver);
		return loginPage;
	}
	public customer_changePassowrd getChangePasswordPage() {
		changePasswordPage = new customer_changePassowrd(driver);
		return changePasswordPage;
	}
	public customer_logoutPage getLogoutPage() {
		 logoutPage = new customer_logoutPage(driver);
		return logoutPage;
	}
	
	
	
}
