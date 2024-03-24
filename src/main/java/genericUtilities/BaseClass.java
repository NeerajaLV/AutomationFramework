package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of TestNG
 * @author neera
 */
public class BaseClass {
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public WebDriver driver;
	//For Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig() {
		System.out.println("===== DB Connection Successful =====");
	}
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String URL=pUtil.readDataFromPropertyFile("url");
		
//		
//		if(BROWSER.equalsIgnoreCase("Chrome")) {
//			driver=new ChromeDriver()//		}
//		else if(BROWSER.equalsIgnoreCase("Edge")) {
//			driver=new EdgeDriver();
//		}
//		else
			driver=new ChromeDriver();
//		
		sUtil.maximizeWindow(driver);
		sUtil.implicitlyWait(driver);
		driver.get(URL);
		
		sdriver=driver;	//listeners
		
		System.out.println("===== Browser Launch Successful =====");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("===== Login To App Successful =====");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("===== Logout Of App Successful =====");
	}
	
	@AfterClass(alwaysRun=true)
	public void acConfig() {
		driver.quit();
		
		System.out.println("===== Browser Closure Successful =====");
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		System.out.println("===== DB Closure Successful =====");
	}
}
