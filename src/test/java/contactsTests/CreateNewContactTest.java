package contactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreatingNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass{
	@Test(groups={"SmokeSuite","RegressionSuite"},invocationCount=3, retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
	public void createContactWithMandatoryDetails1()throws Throwable, IOException {
		System.out.println("SCM Test");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 1, 2);

		//Step-3: Navigate to CONTACTS link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		//Step-4: Click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookupImage();
		//Step-5: Create a contact with mandatory information
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		//Step-6: Verify for contact
		ContactInformationPage cip=new ContactInformationPage(driver);
		String newcon=cip.getTextOfContactHeader();
		System.out.println(newcon);
		Assert.assertTrue(newcon.contains(LASTNAME),"No contact created with lastname "+LASTNAME+"\n");
		System.out.println("Contact "+LASTNAME+" created successfully");
		}
	@Test(groups={"SmokeSuite","RegressionSuite"}, invocationCount=3)
	public void createContactWithMandatoryDetails2()throws Throwable, IOException {

		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 1, 3);

		//Step-3: Navigate to CONTACTS link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		//Step-4: Click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookupImage();
		//Step-5: Create a contact with mandatory information
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		//Step-6: Verify for contact
		ContactInformationPage cip=new ContactInformationPage(driver);
		String newcon=cip.getTextOfContactHeader();
		System.out.println(newcon);
		Assert.assertTrue(newcon.contains(LASTNAME),"No contact created with lastname "+LASTNAME+"\n");
		System.out.println("Contact "+LASTNAME+" created successfully");
		}
}