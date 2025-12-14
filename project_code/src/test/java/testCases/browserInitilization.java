package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utilities.proportiesFileLoader;

public class browserInitilization {
	WebDriver driver;
	proportiesFileLoader requiredPara = new proportiesFileLoader();

	public WebDriver browseInitiation() throws IOException {
		if (driver == null) {
			String browser = requiredPara.getProporty("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();

			} else {
				System.out.println("******Browser is not specified hence opening default****");
				driver = new ChromeDriver();

			}
		}
		return driver;
	}
	
	
	
}
