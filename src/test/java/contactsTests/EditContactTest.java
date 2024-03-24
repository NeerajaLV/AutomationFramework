package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.EditingContactInformationPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class EditContactTest extends BaseClass {
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void editCreatedContactWithRequiredDetails() throws Throwable {
		
		//Read common data - Property file
		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
		//Read test data - Excel file
		String BEFORELASTNAME=eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String AFTERLASTNAME=eUtil.readDataFromExcelFile("Contacts", 4, 3);
		
		//Step-3: Navigate to CONTACTS link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		//Step-4: Search for a contact with last name
		ContactsPage cp = new ContactsPage(driver);
		cp.searchContactWithLastName(SELECTLASTNAME, BEFORELASTNAME);
		//Step-5: Click on contact
		cp.clickOnContactChaithra();
		//Step-6: Click on Edit button
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.clickOnEdit();
		//Step-7: Modify last name and save contact
		EditingContactInformationPage eip=new EditingContactInformationPage(driver);
		eip.editContact(AFTERLASTNAME);
		//Step-8: Verify for contact with edited details
		String editcon= cip.getTextOfContactHeader();
		System.out.println(editcon);
		Assert.assertTrue(editcon.contains(AFTERLASTNAME), "Edit operation failed on contact with lastname "+BEFORELASTNAME+"\n");
		System.out.println("Contact last name "+BEFORELASTNAME+" edited successfully with last name "+AFTERLASTNAME);
	}
}