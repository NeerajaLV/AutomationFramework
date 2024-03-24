package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import contactsTests.EditContactTest;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class DeleteCreatedContact extends  EditContactTest{

	public static void main(String[] args) throws Throwable {
		//createNewContactTest();
		deleteCreatedContact();
	}
	public static void  deleteCreatedContact() throws Throwable
	{
		//Step-1: Create objects for utility classes
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//Read common data - Property file
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 7, 2);
			
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
		//count
		int beforeConCount = driver.findElements(By.xpath("//*[@type='checkbox']")).size()-1;
		System.out.println(beforeConCount);
		Thread.sleep(1000);
		//Step-4: Search for a contact with last name
		WebElement searchCategory=driver.findElement(By.id("bas_searchfield"));
		sUtil.handleDropDown(searchCategory, "Last Name");
		driver.findElement(By.name("search_text")).sendKeys(LASTNAME);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		//Step-5: Click on contact
		driver.findElement(By.xpath("//a[@title='Contacts' and .='"+LASTNAME+"']")).click();
		Thread.sleep(1000);
		//Step-6: Click on Delete button
		driver.findElement(By.name("Delete")).click();
		Thread.sleep(1000);
		//Step-7: Delete contact by confirming
		sUtil.handleAlertOk(driver);
		Thread.sleep(1000);
		//Step-8: Verify for contact deletion
		int afterConCount = driver.findElements(By.xpath("//*[@type='checkbox']")).size()-1;
		System.out.println(afterConCount);
		if(afterConCount==beforeConCount-1)
		System.out.println("Delete operation on contact completed successfully");
		else
		System.out.println("Delete operation failed");
		Thread.sleep(2000);
		//Step-9: Logout of application
		WebElement admin=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		sUtil.handleMouseActionClick(driver, admin);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
}
