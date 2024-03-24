package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class ContactsPage extends SeleniumUtility{

	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactLookupImage;
	@FindBy(id = "bas_searchfield")
	private WebElement SearchField;
	@FindBy(name = "search_text")
	private WebElement SearchFieldText;
	@FindBy(name = "submit")
	private WebElement SearchNow;
	@FindBy(xpath="//a[@title='Contacts' and .='Chaithra']")
	private WebElement ContactChaithra;
	@FindBy(xpath="//a[@title='Contacts' and .='Neeraja']")
	private WebElement ContactNeeraja;
	@FindBy(xpath = "//*[@type='checkbox']")
	private List<WebElement> ContactCount;
	@FindBy(id = "selectCurrentPageRec")
	private WebElement SelectAll;
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement Delete;
	
	//utilization
	public WebElement getCreateContactLookupImage() {
		return CreateContactLookupImage;
	}
	public WebElement getSearchField() {
		return SearchField;
	}
	public WebElement getSearchFieldText() {
		return SearchFieldText;
	}
	public WebElement getSearchNow() {
		return SearchNow;
	}
	public WebElement getContactChaithra() {
		return ContactChaithra;
	}
	public WebElement getSelectAll() {
		return SelectAll;
	}
	public WebElement getDelete() {
		return Delete;
	}
	//public WebElement setContact() {
	//	return Contact;
	//}
	public List<WebElement> getContactCount() {
		return ContactCount;
	}
	
	//Business Library
	/**
	 * This method will click on contact look up image
	 */
	public void clickOnCreateContactLookupImage() {
		CreateContactLookupImage.click();
	}
	/**
	 * This method will search contact with Last Name
	 * @param SELECTTEXT
	 * @param LASTNAME
	 * @throws InterruptedException 
	 */
	public void searchContactWithLastName(String SELECTTEXT, String LASTNAME) throws InterruptedException {
		handleDropDown(SearchField, SELECTTEXT);
		SearchField.click();
		SearchFieldText.sendKeys(LASTNAME);
		SearchNow.click();
		Thread.sleep(2000);
	}
	/**
	 * This method will click on contact Chaithra
	 * @param BEFORELASTNAME
	 */
	public void clickOnContactChaithra() {
		ContactChaithra.click();
	}
	/**
	 * This method will click on contact Neeraja
	 * @param BEFORELASTNAME
	 */
	public void clickOnContactNeeraja() {
		ContactNeeraja.click();
	}
	/**
	 * This method will return the total contact count+1
	 * @return
	 */
	public int getContactCountSize() {
		return ContactCount.size();
	}
	
	/**
	 * This method will select all contacts, click on delete and confirms deletion
	 * @param driver
	 */
	public void deleteAllByConfirming(WebDriver driver) {
		SelectAll.click();
		Delete.click();
		handleAlertOk(driver);
	}
}
