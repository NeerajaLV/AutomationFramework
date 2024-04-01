package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
	//Rule-1: identify web element in web page 
	@FindBy(linkText = "Contacts") 
	private WebElement ContactsLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	@FindBy(linkText = "Sign Out")
	private WebElement SignOut;
	
	//Rule-2: create a constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Rule-3: getter
	public WebElement getContactsLink() {
		return ContactsLink;
	}
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	public WebElement getSignOut() {
		return SignOut;
	}

	//Business library - generic methods related to Home Page
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink() {
		ContactsLink.click();
	}
	/**
	 * This method will logout of application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		AdministratorImg.click();
		handleMouseActionsMoveToElement(driver, AdministratorImg);
		Thread.sleep(1000);
		SignOut.click();
	}
	
	
}
