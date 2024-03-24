package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class SearchContact {
	@Test
	public static void searchContact() throws Throwable
	{
		//Step-1: Create objects for utility classes
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//Read common data - Property file
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 13, 2);
		
		//Step-1: Launch the browser
		WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitlyWait(driver);
		//Step-2:  Login to vtiger application with valid credentials
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		//Step-3: Navigate to CONTACTS link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		Thread.sleep(1000);
		//Step-4: Search for a contact with last name
		ContactsPage cp=new ContactsPage(driver);
		cp.searchContactWithLastName(SELECTLASTNAME, LASTNAME);
		Thread.sleep(2000);
		//Step-5: Verify for contacts
		int conCount = cp.getContactCountSize()-1;
		if(conCount>=1)
			System.out.println("Search successful "+conCount+" contacts found");
		else
			System.out.println("No such contacts found");
		//Step-6: Logout of application
		hp.logoutOfApp(driver);
		driver.quit();
	}
}
