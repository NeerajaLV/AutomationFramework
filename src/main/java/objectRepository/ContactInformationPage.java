package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class ContactInformationPage extends SeleniumUtility{
	//initialization
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(className = "dvHeaderText")
	private WebElement ContactHeader;
	@FindBy(name = "Edit")
	private WebElement Edit;
	@FindBy(name="Delete")
	private WebElement Delete;
	//utilization
	public WebElement getContactHeader() {
		return ContactHeader;
	}
	public WebElement getEdit() {
		return Edit;
	}

	//Business Library
	/**
	 * This method will get the text from contact header
	 * @return
	 */
	public String getTextOfContactHeader() {
		return ContactHeader.getText();
	}
	/**
	 * This method will click on edit button
	 */
	public void clickOnEdit() {
		Edit.click();
	}
	/**
	 * This method will click on delete button
	 * @throws InterruptedException 
	 */
	public void clickOnDeleteAndConfirm(WebDriver driver) throws InterruptedException {
		Delete.click();
		handleAlertOk(driver);
		Thread.sleep(1000);}
}
