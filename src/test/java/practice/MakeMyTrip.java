package practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip{
	@Test
	public void makeMyTrip() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//span[.='Departure']")).click();
	driver.findElement(By.xpath("//div[@aria-label='Thu Apr 04 2024']")).click();
	driver.findElement(By.xpath("//span[.='Return']")).click();
	
	boolean flag=false;
	while(flag==false) {
		if(driver.findElements(By.xpath("//*[@aria-label='Fri Aug 09 2024']")).size()!=0) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@aria-label='Fri Aug 09 2024']")).click();
			flag=true;
		}
		else
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			
	}
	/*
	 * List<WebElement> eles=driver.findElements(By.xpath("//div[@aria-label='Fri Aug 09 2024']"));
	for(WebElement ele: eles) {
		boolean flag=false;
		while(flag==false) {
			if(eles.size()!=0) {
				System.out.println(eles.size());
				ele.click();
				flag=true;
			}
			else
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
	}
	}
	driver.quit();
	 */
}
}