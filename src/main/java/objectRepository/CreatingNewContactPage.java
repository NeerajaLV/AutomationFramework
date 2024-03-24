package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreatingNewContactPage extends SeleniumUtility{
	//initialization
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	//declaration
	@FindBy(name = "lastname")
	private WebElement LastName;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement Save;
	@FindBy(name = "leadsource")
	private WebElement LeadSourceDropDown;
	
	//utilization
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getSave() {
		return Save;
	}
	public WebElement getLeadSourceDropDown() {
		return LeadSourceDropDown;
	}
	
	//Business Library
	/**
	 * This method will create contact with last name and save
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		LastName.sendKeys(LASTNAME);
		Save.click();
	}
	/**
	 * This method will create contact with last name, lead source and save
	 * @param LASTNAME
	 * @param LEADSOURCEVALUE
	 */
	public void createNewContact(String LASTNAME, String LEADSOURCEVALUE) {
		LastName.sendKeys(LASTNAME);
		handleDropDown(LEADSOURCEVALUE,LeadSourceDropDown);
		Save.click();
	}
	
}
