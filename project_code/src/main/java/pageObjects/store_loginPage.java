package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.proportiesFileLoader;

public class store_loginPage {
	WebDriver driver;

	public store_loginPage(WebDriver driver) {
		this.driver = driver;
	}

	proportiesFileLoader requiredPara = new proportiesFileLoader();

	// reference register to test case 07
	By button_newCustomer_Regisration = By.xpath("//*[@id='content']/div/div[1]/div/a");
	// reference login to test case 01
	By inputBox_email = By.xpath("//*[@id='input-email']");
	By inputBox_password = By.xpath("//*[@id='input-password']");
	By link_forgotPassword = By.xpath("//*[@id='content']/div/div[2]/div/form/div[2]/a");
	By button_login = By.xpath("//*[@id='content']/div/div[2]/div/form/input");
	// reference login to test case 02
	By alertMessage_noMatchFound = By.xpath("//*[@class='alert alert-danger alert-dismissible']");
	
	
	public void clickContinue_registerAccount() {
		driver.findElement(button_newCustomer_Regisration).click();

	}

	public void enterEmailLogin(String creds) throws IOException {
		if (creds.equalsIgnoreCase("valid credential")) {
			String email = requiredPara.getProporty("loginCredential_email");
			driver.findElement(inputBox_email).sendKeys(email);
		} else if (creds.equalsIgnoreCase("invalid credential")) {
			String email = requiredPara.getProporty("loginInvalid_email");
			driver.findElement(inputBox_email).sendKeys(email);
		} else if (creds.equalsIgnoreCase(" ")) {
			driver.findElement(inputBox_email).sendKeys(" ");
		}
	}

	public void enterPasswordLogin(String creds) throws IOException {
		if (creds.equalsIgnoreCase("valid credential")) {

			String password = requiredPara.getProporty("loginCredential_password");
			driver.findElement(inputBox_password).sendKeys(password);
		} else if (creds.equalsIgnoreCase("invalid credential")) {
			String password = requiredPara.getProporty("loginInvalid_password");
			driver.findElement(inputBox_password).sendKeys(password);

		} else if (creds.equalsIgnoreCase(" ")) {
			driver.findElement(inputBox_password).sendKeys("");

		}else if (creds.equalsIgnoreCase("password change")) {
			String password = requiredPara.getProporty("changePassword_newPassword");
			driver.findElement(inputBox_password).sendKeys(password);
		}
	}
	public void clickOnForgotPassword() {
		driver.findElement(link_forgotPassword).click();
	}

	public void clickLoginButton() {
		driver.findElement(button_login).click();

	}
	

	public String alertMessage_noMatchFound() {
		String alertMessage = driver.findElement(alertMessage_noMatchFound).getText();
		return alertMessage;
	}
}
