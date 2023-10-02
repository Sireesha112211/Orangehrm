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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Reports {
	private WebDriver driver;
	 private Properties properties;
	 private String baseUrl;
	 
	
	@BeforeTest
	public void setUp() {
		try {
			// Load the properties 
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
	
	
	@BeforeMethod
	public void loginWithValidCredentials() {

		// Get locators from properties
		String userNameTextboxLocator = properties.getProperty("userName_textbox.Locator");
		String passwordTextboxLocator = properties.getProperty("password_textbox.Locator");
		String loginButtonLocator = properties.getProperty("login_button.Locator");
		
		String userName = properties.getProperty("userName1");
		String password = properties.getProperty("password1");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.findElement(By.name(userNameTextboxLocator)).sendKeys(userName);
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
	
	@Test(priority = 1)
	public void AddReport() {
		// Get locators 
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String reportButtonLoc = properties.getProperty("report.Locator");
		String addButtonLoc = properties.getProperty("add_button.Locator");
		String reportNameTxtboxLoc = properties.getProperty("reportName_txtbox.Locator");
		String selectionCriteriaDDLoc = properties.getProperty("selectionCriteria_DD.Locator");
		String selected_selectionCriteriaLoc = properties.getProperty("selectionCriteria_Select.Locator");
		String displayFieldGDDLoc = properties.getProperty("displayFieldGroup_DD.Locator");
		String selected_displayFieldGLoc = properties.getProperty("displayFieldG_Select.Locator");
		String displayFieldDDLoc = properties.getProperty("displayField_DD.Locator");
		String selected_displayFieldLoc = properties.getProperty("displayField_Select.Locator");
		String plusButtonLoc = properties.getProperty("addSelectedDisplayField_button.Locator");
		String toggleButtonLoc = properties.getProperty("toggle_button.Locator");
		String saveButtonLoc = properties.getProperty("save_button.Locator");
		
		String reportName = properties.getProperty("reportName");
		
		//Navigate to PIM 
		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(reportButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(addButtonLoc)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(reportNameTxtboxLoc)).sendKeys(reportName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(selectionCriteriaDDLoc)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(selected_selectionCriteriaLoc)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(displayFieldGDDLoc)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(selected_displayFieldGLoc)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(displayFieldDDLoc)).click();
		driver.findElement(By.xpath(selected_displayFieldLoc)).click();
		driver.findElement(By.xpath(plusButtonLoc)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(displayFieldDDLoc)).click();
		driver.findElement(By.xpath(selected_displayFieldLoc)).click();
		driver.findElement(By.xpath(plusButtonLoc)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(toggleButtonLoc)).click();
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void displayReportDetails() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String reportButtonLoc = properties.getProperty("report.Locator");
		String searchTxtboxLoc = properties.getProperty("searchReportName_txtbox.Locator");
		String searchButtonLoc = properties.getProperty("search_Button.Locator");
		String displayButtonLoc = properties.getProperty("display_Button.Locator");
		String displayReportName = properties.getProperty("displayReportName");
		
		String reportName = properties.getProperty("reportName");
		
		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(reportButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//search the report name
		driver.findElement(By.xpath(searchTxtboxLoc)).sendKeys(reportName);
		driver.findElement(By.xpath(searchButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(displayButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualDisplayReportName = driver.findElement(By.tagName(displayReportName)).getText();
		
		AssertJUnit.assertEquals(reportName, actualDisplayReportName);
		
		
	}
	
	@Test(priority = 3)
	public void UpdateReport() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String reportButtonLoc = properties.getProperty("report.Locator");
		String searchTxtboxLoc = properties.getProperty("searchReportName_txtbox.Locator");
		String searchButtonLoc = properties.getProperty("search_Button.Locator");
		String updateButtonLoc = properties.getProperty("update_Button.Locator");
		String updateReportNameTxtboxLoc = properties.getProperty("reportName_txtbox.Locator");
		String saveButtonLoc = properties.getProperty("save_button.Locator");
		
		String reportName = properties.getProperty("reportName");
		String updateRepotName = properties.getProperty("UpdatedReportName");
		
		//Navigate to PIM Module
		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(reportButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//search the report name
		driver.findElement(By.xpath(searchTxtboxLoc)).sendKeys(reportName);
		driver.findElement(By.xpath(searchButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//click on the update button
		driver.findElement(By.xpath(updateButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(updateReportNameTxtboxLoc)).clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//update the report name
		driver.findElement(By.xpath(updateReportNameTxtboxLoc)).sendKeys(updateRepotName);
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void deleteReport() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String reportButtonLoc = properties.getProperty("report.Locator");
		String searchTxtboxLoc = properties.getProperty("searchReportName_txtbox.Locator");
		String searchButtonLoc = properties.getProperty("search_Button.Locator");
		String deleteButtonLoc = properties.getProperty("delete_Button.Locator");
		String deletePopupLoc = properties.getProperty("confirm_DeletePopup.Locator");
		
		String updateRepotName = properties.getProperty("UpdatedReportName");
		
		//Navigate to PIM Module
		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(reportButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//search the report name
		driver.findElement(By.xpath(searchTxtboxLoc)).sendKeys(updateRepotName);
		driver.findElement(By.xpath(searchButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//delete the report
		driver.findElement(By.xpath(deleteButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//confirm  popup 
		driver.findElement(By.xpath(deletePopupLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void logOut() {
		// Get locators from properties
		String adminNameDDLoc = properties.getProperty("adminName_DD.Loc");
		String logoutLinkLoc = properties.getProperty("logout_link.Loc");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
