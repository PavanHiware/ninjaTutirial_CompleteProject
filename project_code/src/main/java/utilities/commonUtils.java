package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class commonUtils {
	WebDriver driver;
	public commonUtils(WebDriver driver) {
	this.driver=driver;
	}
	
	public void scrollDown(int ptOne, int ptTwo) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+ptOne+","+ptTwo+")");
			
			
	}
	public void scrollDownToElement(WebElement targetelement) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", targetelement);
		
		
	}
	
	public void navigateTo(String navigation) {
		if (navigation.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (navigation.equalsIgnoreCase("back")) {
			driver.navigate().back();;
		}else if (navigation.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();;
		}
		
	}
}
