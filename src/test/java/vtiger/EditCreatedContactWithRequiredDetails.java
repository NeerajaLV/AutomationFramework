package vtiger;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class EditCreatedContactWithRequiredDetails extends CreateContactWithMandatoryDetails{
	public static void main(String[] args) throws Throwable
	{
		createContactWithMandatoryDetails();
		editCreatedContactWithRequiredDetails();
	}
	public static void editCreatedContactWithRequiredDetails() throws Throwable {
		//Step-1: Create objects for utility classes
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//Read common data - Property file
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		//Read test data - Excel file
		String BEFORELASTNAME=eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String AFTERLASTNAME=eUtil.readDataFromExcelFile("Contacts", 4, 3);
		
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
		WebElement contacts = driver.findElement(By.linkText("Contacts"));
		contacts.click();
		Thread.sleep(1000);
		//Step-4: Search for a contact with last name
		WebElement searchCategory=driver.findElement(By.id("bas_searchfield"));
		sUtil.handleDropDown(searchCategory, "Last Name");
		searchCategory.click();
		driver.findElement(By.name("search_text")).sendKeys(BEFORELASTNAME);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		//Step-5: Click on contact
		driver.findElement(By.xpath("//a[@title='Contacts' and .='"+BEFORELASTNAME+"']")).click();
		Thread.sleep(1000);
		//Step-6: Click on Edit button
		driver.findElement(By.name("Edit")).click();
		//Step-7: Modify last name and save contact
		WebElement lastname=driver.findElement(By.name("lastname"));
		lastname.click();
		Thread.sleep(1000);
		lastname.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		lastname.sendKeys(AFTERLASTNAME);
		WebElement savecon = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		savecon.click();
		//Step-8: Verify for contact with edited details
		String editcon=driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(editcon);
		if(editcon.contains(AFTERLASTNAME))
			System.out.println("Edit operation on created contact done successfully");
		else
			System.out.println("Edit operation failed");
		Thread.sleep(2000);
		//Step-9: Logout of application
		WebElement admin=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		sUtil.handleMouseActionClick(driver, admin);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
