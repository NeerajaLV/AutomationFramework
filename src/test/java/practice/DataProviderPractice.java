package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider="logindata")
	public void loginToApp(String uname, String password) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
		System.out.println("Login Success");
	}
	@DataProvider(name="logindata")
	public Object[][] dataSet1(){
		
		return new Object[][] {
			{"admin","manager"},
			{"admin", "admin"}
		};
		
	}

}
