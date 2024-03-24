package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class SearchContactTest extends BaseClass{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void searchContact1() throws Throwable{
		
		//Read common data - Property file
		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 13, 2);
		
		//Step-3: Navigate to CONTACTS link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		//Step-4: Search for a contact with last name
		ContactsPage cp=new ContactsPage(driver);
		cp.searchContactWithLastName(SELECTLASTNAME, LASTNAME);
		//Step-5: Verify for contacts
		int conCount = cp.getContactCountSize()-1;
		Assert.assertTrue(conCount>=1, "No contact found with lastname "+LASTNAME+"\n");
		System.out.println("Search successful..!!\n"+conCount+" contacts found with lastname "+LASTNAME);
	}
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void searchContact2() throws Throwable{
		
		//Read common data - Property file
		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 13, 3);
		
		//Step-3: Navigate to CONTACTS link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		//Step-4: Search for a contact with last name
		ContactsPage cp=new ContactsPage(driver);
		cp.searchContactWithLastName(SELECTLASTNAME, LASTNAME);
		//Step-5: Verify for contacts
		int conCount = cp.getContactCountSize()-1;
		Assert.assertTrue(conCount>=1, "No contact found with lastname "+LASTNAME+"\n");
		System.out.println("Search successful..!!\n"+conCount+" contacts found with lastname "+LASTNAME);
	}
}
