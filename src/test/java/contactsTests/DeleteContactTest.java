package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class DeleteContactTest extends BaseClass{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void  deleteCreatedContact1() throws Throwable {

		//Read common data - Property file
		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 7, 2);

		//Step-3: Navigate to CONTACTS link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		//count
		ContactsPage cp= new ContactsPage(driver);
		int beforeConCount = cp.getContactCountSize()-1;
		System.out.println("Total contact count before search & deletion operation: "+beforeConCount);
		Assert.assertTrue(beforeConCount>=1,"No contacts present to perform deletion operation\n");
		//Step-4: Search for a contact with last name
		cp.searchContactWithLastName(SELECTLASTNAME, LASTNAME);
		int conCount = cp.getContactCountSize()-1;
		System.out.println("Total contact count of "+LASTNAME+" before deletion operation: "+conCount);
		//Step-5: Click on contact
		Assert.assertTrue(conCount>=1, "No contact found with lastname "+LASTNAME+"\n");
		cp.clickOnContactChaithra();
		//Step-6: Click on Delete button
		//Step-7: Delete contact by confirming
		ContactInformationPage cip=new ContactInformationPage(driver);
		cip.clickOnDeleteAndConfirm(driver);
		//Step-8: Verify for contact deletion
		int afterConCount = cp.getContactCountSize()-1;
		System.out.println("Total contact count after search & deletion operation: "+afterConCount);
		Thread.sleep(2000);
		Assert.assertEquals(afterConCount, beforeConCount-1, "Delete operation failed on contact with lastname "+LASTNAME+"\n");
		System.out.println("Contact "+LASTNAME+" deleted successfully");
	}
//	@Test(groups={"SmokeSuite","RegressionSuite"})
//	public void  deleteCreatedContact2() throws Throwable {
//
//		//Read common data - Property file
//		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
//		//Read test data - Excel file
//		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 7, 3);
//
//		//Step-3: Navigate to CONTACTS link
//		HomePage hp=new HomePage(driver);
//		hp.clickOnContactsLink();
//		//count
//		ContactsPage cp= new ContactsPage(driver);
//		int beforeConCount = cp.getContactCountSize()-1;
//		System.out.println("Total contact count before search & deletion operation: "+beforeConCount);
//		Assert.assertTrue(beforeConCount>=1,"No contacts present to perform deletion operation\n");
//		//Step-4: Search for a contact with last name
//		cp.searchContactWithLastName(SELECTLASTNAME, LASTNAME);
//		int conCount = cp.getContactCountSize()-1;
//		System.out.println("Total contact count of "+LASTNAME+" before deletion operation: "+conCount);
//		//Step-5: Click on contact
//		Assert.assertTrue(conCount>=1, "No contact found with lastname "+LASTNAME+"\n");
//		cp.clickOnContactNeeraja();
//		//Step-6: Click on Delete button
//		//Step-7: Delete contact by confirming
//		ContactInformationPage cip=new ContactInformationPage(driver);
//		cip.clickOnDeleteAndConfirm(driver);
//		//Step-8: Verify for contact deletion
//		int afterConCount = cp.getContactCountSize()-1;
//		System.out.println("Total contact count after search & deletion operation: "+afterConCount);
//		Thread.sleep(2000);
//		Assert.assertEquals(afterConCount, beforeConCount-1, "Delete operation failed on contact with lastname "+LASTNAME+"\n");
//		System.out.println("Contact "+LASTNAME+" deleted successfully");
//	}
}
