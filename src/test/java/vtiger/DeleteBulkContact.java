package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class DeleteBulkContact extends BaseClass{
/*
	public static void main(String[] args) throws Throwable {
		/*
		for(int i=0;i<2;i++)
		{
			createContactWithMandatoryDetails();
		}
		
		//deleteBulkContact();}
	*/
	@Test
	public static void deleteBulkContact() throws Throwable
	{
		
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 10, 2);
		
		//Step-3: Navigate to CONTACTS link
		WebElement contacts = driver.findElement(By.linkText("Contacts"));
		contacts.click();
		//Select all contacts
		int beforeConCount = driver.findElements(By.xpath("//*[@type='checkbox']")).size()-1;
		System.out.println("Total contact count before search & deletion operation: "+beforeConCount);
		if(beforeConCount>=1)
		{
		WebElement searchCategory=driver.findElement(By.id("bas_searchfield"));
		sUtil.handleDropDown(searchCategory, "Last Name");
		driver.findElement(By.name("search_text")).sendKeys(LASTNAME);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		int conCount = driver.findElements(By.xpath("//*[@type='checkbox']")).size()-1;
		System.out.println("Total contact count of "+LASTNAME+" before deletion operation: "+conCount);
		if(conCount>=1) {
		driver.findElement(By.id("selectCurrentPageRec")).click();
		//Click on Delete button
		WebElement delete = driver.findElement(By.xpath("//input[@value='Delete']"));
		delete.click();
		Thread.sleep(1000);
		//Delete contact by confirming
		sUtil.handleAlertOk(driver);
		Thread.sleep(1000);
		//Verify for contact deletion
		//sUtil.navigateRefresh(driver);
		int afterConCount = driver.findElements(By.xpath("//*[@type=\"checkbox\"]")).size()-1;
		System.out.println("Total contact count of "+LASTNAME+" before deletion operation: "+afterConCount);
		Thread.sleep(1000);
		if(afterConCount==beforeConCount-conCount)
			System.out.println("Delete operation of selected bulk contacts completed successfully");
		else
			System.out.println("Delete operation of bulk contacts failed");
		}
		else
			System.out.println("No such contacts present to perform deletion operation");
		}
		else
			System.out.println("No contacts present to perform deletion operation");
		Thread.sleep(2000);
		//Logout of application
		WebElement admin=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		sUtil.handleMouseActionClick(driver, admin);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
