package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class customer_logoutPage {
	WebDriver driver;

	public customer_logoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By button_continue = By.xpath("//*[@class='buttons']/div/a");
	
	public void clickContinue() {
		driver.findElement(button_continue).click();
	}
}
