package vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import genericUtilities.ExcelFileUtility;

public class CreateContactWithMandatoryDetails {
	public static void main(String[] args) throws Throwable, IOException
	{
		createContactWithMandatoryDetails();
	}
	public static void createContactWithMandatoryDetails()throws Throwable, IOException {
		//Step-1: Create objects of utility classes
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//Read common data - Property file
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 1, 2);
		
		//Step-1: Launch the browser
		WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitlyWait(driver);
		//Step-2:  Login to vtiger application with valid credentials
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		//Step-3: Navigate to CONTACTS link	
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(1000);
		//Step-4: Click on create contact look up image
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		//Step-5: Create a contact with mandatory information
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Step-6: Verify for contact
		String newcon=driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(newcon);
		if(newcon.contains(LASTNAME))
			System.out.println("Contact created successfully");
		else
			System.out.println("No such contact found");
		Thread.sleep(2000);
		//Step-7: Logout of application
		WebElement admin=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		sUtil.handleMouseActionClick(driver, admin);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}
