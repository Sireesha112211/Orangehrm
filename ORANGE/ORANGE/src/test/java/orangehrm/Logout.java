package orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logout {
	private WebDriver driver;
	private Properties properties;
	private String baseUrl;
	
	
	@BeforeTest
	public void setUp() {
		
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream("config_3.properties");
			properties = new Properties();
			try {
				properties.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		baseUrl = properties.getProperty("base.url");
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void loginWithValidCredentials() {
		// Get locators 
		String userNameTextboxLocator = properties.getProperty("userName_textbox.Locator");
		String passwordTextboxLocator = properties.getProperty("password_textbox.Locator");
		String loginButtonLocator = properties.getProperty("login_button.Locator");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String userName = properties.getProperty("userName1");
		String password = properties.getProperty("password1");
		
		driver.findElement(By.xpath(userNameTextboxLocator)).sendKeys(userName);
		driver.findElement(By.xpath(passwordTextboxLocator)).sendKeys(password);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(loginButtonLocator)).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Dashboard";
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void logOut() {
		// Get locators from properties
		String adminNameDDLoc = properties.getProperty("adminName_DD.Loc");
		String logoutLinkLoc = properties.getProperty("logout_link.Loc");
		
		driver.findElement(By.xpath(adminNameDDLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(logoutLinkLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
