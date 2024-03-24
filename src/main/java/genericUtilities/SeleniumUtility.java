package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods to use selenium webdriver utilities
 * @author neera
 */
public class SeleniumUtility {
	//Maximize and Minimize window
	/**
	 * This method will maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
	}
	/**
	 * This method will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	//navigate methods
	/**
	 * This method will refresh the current window
	 * @param driver
	 */
	public void navigateRefresh(WebDriver driver) {
			driver.navigate().refresh();
	}
	/**
	 * This method will navigate to previous window
	 * @param driver
	 */
	public void navigateBack(WebDriver driver) {
			driver.navigate().back();
	}
	/**
	 * This method will navigate to previous window
	 * @param driver
	 */
	public void navigateForward(WebDriver driver) {
			driver.navigate().forward();
	}
	
	//Waits
	/**
	 * This method will add implicitly wait of 10 secs
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will add explicit wait of 10 secs for visibility of element
	 * @param driver
	 * @param element
	 */
	public void waitElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will add explicit wait of 10 secs for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Handling Drop Down
	/**
	 * This method will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle drop down by Visible Text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will handle drop down by Value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value, WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	//Handling Mouse Hover Actions
	/**
	 * This method will handle mouse hover action of moving to element
	 * @param driver
	 * @param element
	 */
	public void handleMouseActionsMoveToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will handle mouse hover action of moving by offset
	 * @param driver
	 * @param element
	 */
	public void handleMouseActionsMoveByOffset(WebDriver driver, int x, int y) {
		Actions act=new Actions(driver);
		act.moveByOffset(x, y);
	}
	/**
	 * This method will handle mouse hover action of clicking on element
	 * @param driver
	 * @param element
	 */
	public void handleMouseActionClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	/**
	 * This method will handle mouse hover action of double clicking on element
	 * @param driver
	 * @param element
	 */
	public void handleMouseActionDoubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will handle mouse hover action of right click of element
	 * @param driver
	 * @param element
	 */
	public void handleMouseActionContextClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will handle mouse hover action of drag and drop of element
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void handleMouseActionDragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
	}
	/**
	 * This method will handle mouse hover action of click & hold and release of element
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	public void handleMouseActionClickAndHold(WebDriver driver, WebElement drag, WebElement drop) {
		Actions act=new Actions(driver);
		act.clickAndHold(drag).release(drop).build().perform();
	}
	//Handling Scroll Bar
	/**
	 * This method will handle scroll bar to element by x and y co-ordinates
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void handleScrollBar(WebDriver driver, int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(x,y)");
	}
	/**
	 * This method will handle scroll bar to window top
	 * @param driver
	 */
	public void handleScrollBarWindowTop(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.scrollHeight");
	}
	/**
	 * This method will handle scroll bar to window bottom
	 * @param driver
	 */
	public void handleScrollBarWindowBottom(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,-document.scrollHeight");
	}
	/**
	 * This method will handle scroll bar to move to element
	 * @param driver
	 * @param element
	 */
	public void handleScrollBar(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	//Handling Frames
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame by id
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * This method will handle frame by web element
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	//Handling Alert
	/**
	 * This method will handle alert by clicking on ok
	 * @param driver
	 */
	public void handleAlertOk(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will handle alert by clicking on cancel
	 * @param driver
	 */
	public void handleAlertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will handle alert by sending key values
	 * @param driver
	 */
	public void handleAlertSendKeys(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	/**
	 * This method will handle alert by getting text
	 * @param driver
	 */
	public String handleAlertGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	//Handling Pop Ups
	//Screenshot
	/**
	 * This method will take screenshot of current window and returns path of the screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String capturScreenshot(WebDriver driver, String screenshotName) throws IOException {
	TakesScreenshot s=(TakesScreenshot)driver;
	File src = s.getScreenshotAs(OutputType.FILE);
	File dst=new File(".\\Screenshots\\"+screenshotName+".png");
	Files.copy(src, dst);
	return dst.getAbsolutePath(); //used in Extent reports
	}
}
