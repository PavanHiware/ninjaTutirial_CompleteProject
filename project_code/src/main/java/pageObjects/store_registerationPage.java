package pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.proportiesFileLoader;

public class store_registerationPage {
	WebDriver driver;

	public store_registerationPage(WebDriver driver) {

		this.driver = driver;
	}
	proportiesFileLoader requiredPara = new proportiesFileLoader();
	
	//reference to test case 01
	By input_firstName = By.id("input-firstname");
	By input_lastName = By.id("input-lastname");
	By input_email = By.id("input-email");
	By input_phoneNumber = By.id("input-telephone");
	By input_password = By.id("input-password");
	By input_confiPassword = By.id("input-confirm");
	By checkBox_privacyPolicy = By.xpath("//*[@name='agree']");
	By button_continue = By.xpath("//*[@class='btn btn-primary']");
	By button_conFirmContinue = By.xpath("//*[@class='btn btn-primary']");
	By alertMessage_AccountCreation = By.xpath("//*[@class='alert alert-danger alert-dismissible']");
	By successMessage_AccountCreation = By.xpath("//*[@id='content']/h1");
	//reference to test case 04
	By alertMessage_privacyPolicy = By.xpath("//*[@class='alert alert-danger alert-dismissible']");
	By errorMessage_firstName = By.xpath("//*[@id='account']/div[2]/div/div");
	By errorMessage_lastName = By.xpath("//*[@id='account']/div[3]/div/div");
	By errorMessage_email = By.xpath("//*[@id='account']/div[4]/div/div");
	By errorMessage_telephone = By.xpath("//*[@id='account']/div[5]/div/div");
	By errorMessage_password = By.xpath("//*[@class='form-horizontal']/fieldset[2]/div[1]/div/div");
	//reference to test case 05
	By radioButton_subscibeYes = By.xpath("//*[@class='form-group']/div/label[1]/input");
	// reference to test case 07
	By coloumLink_dropMenu = By.xpath("//*[@id=\"column-right\"]/div/a");
	
	public String enterFirstName(String firstName) throws IOException {
//		String name = requiredPara.getProporty(firstName);
		driver.findElement(input_firstName).sendKeys(firstName);
//		System.out.println(name);
		return firstName;
	}

	public String enterLastName(String lastName) throws IOException {
//		String surname = requiredPara.getProporty(lastName);
		driver.findElement(input_lastName).sendKeys(lastName);
//		System.out.println(surname);
		return lastName;
	}

	public String enterEmail(String emailID) throws IOException {
//		String email = requiredPara.getProporty(emailID);
		driver.findElement(input_email).sendKeys(emailID);
//		System.out.println(email);
		return emailID;
	}

	public void enterPhoneNumber(String contactNo) throws IOException {
//		String phoneNum = requiredPara.getProporty(contactNo);
		driver.findElement(input_phoneNumber).sendKeys(contactNo);

	}

	public void enterPasswordAndVerify(String password) throws IOException {
//		String pass = requiredPara.getProporty(password);
		driver.findElement(input_password).sendKeys(password);
		driver.findElement(input_confiPassword).sendKeys(password);

	}

	public void checkPrivacyPolicy() {
		driver.findElement(checkBox_privacyPolicy).click();

	}

	public void clickContinueAndVerify() {
		driver.findElement(button_continue).click();

	}

	public void confirmAndContinue() {

		if (driver.findElement(successMessage_AccountCreation).getText()
				.equalsIgnoreCase("Your Account Has Been Created!")) {
			driver.findElement(button_conFirmContinue).click();			

		} else if (driver.findElement(alertMessage_AccountCreation).getText()
				.equalsIgnoreCase("Warning: E-Mail Address is already registered!")) {
			System.out.println(
					driver.findElement(alertMessage_AccountCreation).getText() + " " + " Please provide another email");
		} else {
			System.out.println("facing issue for registration....");
		}
	}
	
	public String alertMessageprivacyPolicy() {
		String errorMsg = driver.findElement(alertMessage_privacyPolicy).getText();
		return errorMsg;
	}
	public String errorMessage_firstName() {
		String errorMsg_firstName = driver.findElement(errorMessage_firstName).getText();
		return errorMsg_firstName;
	}
	public String errorMessage_lastName() {
		String errorMsg_lastName = driver.findElement(errorMessage_lastName).getText();
		return errorMsg_lastName;
	}
	public String errorMessage_email() {
		String errorMsg_email = driver.findElement(errorMessage_email).getText();
		return errorMsg_email;
	}
	public String errorMessage_telephone() {
		String errorMsg_telephone = driver.findElement(errorMessage_telephone).getText();
		return errorMsg_telephone;
	}
	public String errorMessage_password() {
		String errorMsg_password = driver.findElement(errorMessage_password).getText();
		return errorMsg_password;
	}
	public void clickYesToSubscribe() {
		driver.findElement(radioButton_subscibeYes).click();
		
	}

	public void selectLink_from_dropMenu(String requiredMenuOption) {
		List<WebElement> dropMenuLinks = driver.findElements(coloumLink_dropMenu);
		for (int l = 0; l < dropMenuLinks.size(); l++) {
			String menuText = dropMenuLinks.get(l).getText();
			if (menuText.equalsIgnoreCase(requiredMenuOption)) {
				dropMenuLinks.get(l).click();
				break;
			}
		}
	}
}
