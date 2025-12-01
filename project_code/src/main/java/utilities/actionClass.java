package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actionClass {
	WebDriver driver;

	public actionClass(WebDriver driver) {
		this.driver = driver;

	}
	
	public void enterValueViaActionMethod(WebElement locationElement, String valueToEnter) {
		Actions action = new Actions(driver);
		action.click(locationElement).sendKeys(valueToEnter).build().perform();
	}
	
	public void selectViaActionMethod(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform();
		
		
	}
}
