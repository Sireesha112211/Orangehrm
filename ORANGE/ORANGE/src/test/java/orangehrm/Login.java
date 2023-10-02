package orangehrm;

import org.testng.annotations.AfterMethod;
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
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	private WebDriver driver;
	private Properties properties;
	private String baseUrl;
	
	
	@BeforeMethod
	public void setUp() {
		
		try {//properties file
			FileInputStream file = new FileInputStream("config_2.properties");
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
	
	@Test
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
		//Enter Login Details
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
		//click on the login button
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
	public void LoginWithInvalidCredentials() {
		// Get locators from properties
				String userNameTextboxLocator = properties.getProperty("userName_textbox.Locator");
				String passwordTextboxLocator = properties.getProperty("password_textbox.Locator");
				String loginButtonLocator = properties.getProperty("login_button.Locator");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String userName = properties.getProperty("userName2");
				String password = properties.getProperty("password2");
				
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
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String actualError = driver.findElement(By.xpath("(//div[@class='oxd-alert-content oxd-alert-content--error'])[1]")).getText();
				AssertJUnit.assertEquals(actualError, "Invalid credentials");
				
				
	}
	
	@Test
	public void loginWithEmptyFields() {
		// Get locators from properties
		String userNameTextboxLocator = properties.getProperty("userName_textbox.Locator");
		String passwordTextboxLocator = properties.getProperty("password_textbox.Locator");
		String loginButtonLocator = properties.getProperty("login_button.Locator");
		String actual_Error = properties.getProperty("actualError");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.findElement(By.xpath(userNameTextboxLocator)).sendKeys("");
		driver.findElement(By.xpath(passwordTextboxLocator)).sendKeys("");
		
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
		
		String actualError = driver.findElement(By.xpath(actual_Error)).getText();
		String  expectedError= "Required";
		
		AssertJUnit.assertEquals(actualError, expectedError);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
