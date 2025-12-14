package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import pageObjects.pageObjectManager;
import utilities.proportiesFileLoader;

public class baseClass {
	public static WebDriver driver;
	public pageObjectManager pageObjectManager;
	browserInitilization browserInit = new browserInitilization();
	proportiesFileLoader requiredPara = new proportiesFileLoader();

	@BeforeSuite
	public void invokeBrowser() throws IOException {
		driver = browserInit.browseInitiation();

		pageObjectManager = new pageObjectManager(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		openApplication("tutorialNinjaApplication");
	}

	@BeforeMethod
	public void resetToHomePage() throws IOException {
		driver.manage().deleteAllCookies();
		openApplication("tutorialNinjaApplication");
	}

	@AfterSuite
	public void closeBroser() {

		if (driver != null) {
			driver.quit(); // Quit completely after each test
		}

	}

	public void openApplication(String applicationName) throws IOException {
		driver.get(requiredPara.getProporty(applicationName));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String captureScreenshot() throws IOException {

		Date currentDate = new Date();
		String ssName = currentDate.toString().replace(" ", "_").replace(":", "_");
		File ssFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destiFile_ss = "C:\\Users\\2110883\\project\\ninjaTutorialsWebsite\\screenshots\\" + ssName + ".png";
		Files.copy(ssFile, new File(destiFile_ss));
		return destiFile_ss;
	}

}
