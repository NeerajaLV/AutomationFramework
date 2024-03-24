package objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingContactInformationPage {
	//initialization
	public EditingContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name = "lastname")
	private WebElement LastName;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement Save;
	
	//utilization
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getSave() {
		return Save;
	}
	
	//Business Library
	/**
	 * This method will edit the created/existing contact and Save
	 * @param AFTERLASTNAME
	 */
	public void editContact(String AFTERLASTNAME) {
		LastName.click();
		//Thread.sleep(1000);
		LastName.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		LastName.sendKeys(AFTERLASTNAME);
		Save.click();
	}
	
}
