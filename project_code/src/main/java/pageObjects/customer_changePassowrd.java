package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.proportiesFileLoader;

public class customer_changePassowrd {
	WebDriver driver;

	public customer_changePassowrd(WebDriver driver) {
		this.driver = driver;
	}

	proportiesFileLoader requiredPara = new proportiesFileLoader();
	By input_password = By.xpath("//*[@id='input-password']");
	By input_confirmPassword = By.xpath("//*[@id='input-confirm']");
	By button_continue = By.xpath("//*[@class='btn btn-primary']");

	public void changePassword_enterNewPassword() throws IOException {
		String password = requiredPara.getProporty("changePassword_newPassword");
		driver.findElement(input_password).sendKeys(password);
	}
	public void changePassword_confirmNewPassword() throws IOException {
		String password = requiredPara.getProporty("changePassword_newPassword");
		driver.findElement(input_confirmPassword).sendKeys(password);
	}
	public void clickContinue_passwordChange() {
		driver.findElement(button_continue).click();
	}
}
