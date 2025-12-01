package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class customer_accountHomePage {
	
	WebDriver driver;

	public customer_accountHomePage(WebDriver driver) {
		this.driver = driver;
	}
//	By link_logo = By.xpath("//*[@id='logo']/h1/a");
	By link_logo = By.linkText("Qafox.com");
	By linkButton_subscribe_noSubscribeTo_newsLetter =  By.xpath("//*[@id='content']/ul[4]//a");
	// reference logout test case 01
	By link_logout = By.xpath("//*[@class='dropdown-menu dropdown-menu-right']/li[5]/a");

	
//	By heading_accountPage = By.xpath("//*[@id='content']/h2[1]");
	
	public Boolean validateAccountPage() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement logo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(link_logo)));
		return logo.isDisplayed();
	}
	
	public void validateSubscription() {
		driver.findElement(linkButton_subscribe_noSubscribeTo_newsLetter).click();
	}
	public void clickLogoutButton() {
		
		driver.findElement(link_logout).click();
	}
}
