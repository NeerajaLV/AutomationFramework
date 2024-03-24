package practice;

//import java.io.File;
import java.io.IOException;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.google.common.io.Files;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;
import objectRepository.ContactsPage;
import objectRepository.HomePage;
import objectRepository.CreatingNewContactPage;
import objectRepository.ContactInformationPage;



public class Scroll {

	public static void main(String[] args) throws InterruptedException, IOException {
		/*
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String screenshotName;
		screenshot(driver, "screenshot1");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		/*
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-500)");
		
		//js.executeScript("window.scrollTo(0,-document.body.scrollHeight");
		js.executeScript("window.scrollTo(0,document.body.scrollHeight");
		//driver.quit();
	}

	public static void screenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot s=(TakesScreenshot)driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dst);
		}
	*/
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
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				Thread.sleep(1000);
				//Step-3: Navigate to CONTACTS link	
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				Thread.sleep(1000);
				//Step-4: Click on create contact look up image
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContactLookupImage();
				//Step-5: Create a contact with mandatory information
				CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
				cncp.createNewContact(LASTNAME);
				//Step-6: Verify for contact
				ContactInformationPage cip=new ContactInformationPage(driver);
				String newcon=cip.getTextOfContactHeader();
				System.out.println(newcon);
				if(newcon.contains(LASTNAME))
					System.out.println("Created contact successfully");
				else
					System.out.println("No such contact found");
				Thread.sleep(2000);
				//Step-7: Logout of application
				hp.logoutOfApp(driver);
				driver.quit();
	}
}