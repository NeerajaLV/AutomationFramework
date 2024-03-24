package vtiger;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EditBulkContact {

	public static void main(String[] args) throws Throwable {
		editBulkContact();
	}
	public static void editBulkContact() throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Login to vtiger application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		//Navigate to CONTACTS link
		WebElement contacts = driver.findElement(By.xpath("//a[.=\"Contacts\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(contacts).perform();
		act.click(contacts).perform();
		Thread.sleep(1000);
		//Select all contacts
		driver.findElement(By.xpath("//input[@type=\"checkbox\" and @name=\"selectall\"]")).click();
		//Click on Mass Edit button
		WebElement massEdit = driver.findElement(By.xpath("//input[@value=\"Mass Edit\"]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",massEdit);
		massEdit.click();
		//Modify last name and save contact
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book=WorkbookFactory.create(fise);
		String LastName=book.getSheet("Contacts").getRow(4).getCell(2).getStringCellValue();
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		//Verify for contacts with edited details
		//Logout of application

	}
}
