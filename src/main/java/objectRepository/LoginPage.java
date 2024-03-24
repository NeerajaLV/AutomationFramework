package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {// Rule-1: create separate POM class for every web page
	//Rule-2: identify web elements in web page using @findBy
	@FindBy(name="user_name") 
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	//Rule-3: create a constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Rule-4: getters

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	//Business library - generic method related to project
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) {
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(USERNAME);
		LoginBtn.click();
	}
	
}
