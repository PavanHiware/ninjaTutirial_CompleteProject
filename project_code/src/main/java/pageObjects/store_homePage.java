package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class store_homePage {
	WebDriver driver;

	public store_homePage(WebDriver driver) {
		this.driver = driver;
	}

	By link_myAccount = By.xpath("//*[@id='top-links']/ul/li[2]");
	By link_register = By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]");
	// reference login test case 01
	By link_login = By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]");

	public void clickMyAccount() {

		driver.findElement(link_myAccount).click();

	}

	public void clickRegisterAccount() {
		driver.findElement(link_register).click();

	}

	public void clickLogin() {
		driver.findElement(link_login).click();

	}
}
