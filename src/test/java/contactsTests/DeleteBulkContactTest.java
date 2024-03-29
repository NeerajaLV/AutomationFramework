package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class DeleteBulkContactTest extends BaseClass{
//	@Test(groups={"SmokeSuite","RegressionSuite"})
//	public void deleteBulkContact1() throws Throwable{
//
//		//Read common data - Property file
//		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
//		//Read test data - Excel file
//		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 10, 2);
//
//		//Step-3: Navigate to CONTACTS link
//		HomePage hp=new HomePage(driver);
//		hp.clickOnContactsLink();
//		//Step-4: Select all contacts
//		//Step-5: Click on Delete button
//		//Step-6: Delete contact by confirming
//		ContactsPage cp=new ContactsPage(driver);
//		int beforeConCount = cp.getContactCountSize()-1;
//		System.out.println("Total contact count before search & deletion operation: "+beforeConCount);
//		Assert.assertTrue(beforeConCount>=1,"No contacts present to perform deletion operation\n");
//		cp.searchContactWithLastName(SELECTLASTNAME, LASTNAME);
//		int conCount = cp.getContactCountSize()-1;
//		System.out.println("Total contact count of "+LASTNAME+" before deletion operation: "+conCount);
//		Assert.assertTrue(conCount>=1,"No contact found with lastname "+LASTNAME+"\n");
//		cp.deleteAllByConfirming(driver);
//		Thread.sleep(2000);
//		//Step-7: Verify for contact deletion
//		hp.clickOnContactsLink();
//		Thread.sleep(2000);
//		int afterConCount = cp.getContactCountSize()-1;
//		System.out.println("Total contact count after search & deletion operation: "+afterConCount);
//		Thread.sleep(2000);
//		Assert.assertEquals(afterConCount, beforeConCount-conCount,"Delete operation of bulk contacts failed on contact with lastname "+LASTNAME+"\n");
//		System.out.println("Bulk deletion of contact "+LASTNAME+" completed successfully");
//	}
	//Contact-2
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void deleteBulkContact2() throws Throwable
	{

		//Read common data - Property file
		String SELECTLASTNAME=pUtil.readDataFromPropertyFile("selectlastname");
		//Read test data - Excel file
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 10, 3);

		//Step-3: Navigate to CONTACTS link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		//Step-4: Select all contacts
		//Step-5: Click on Delete button
		//Step-6: Delete contact by confirming
		ContactsPage cp=new ContactsPage(driver);
		int beforeConCount = cp.getContactCountSize()-1;
		System.out.println("Total contact count before search & deletion operation: "+beforeConCount);
		Assert.assertTrue(beforeConCount>=1,"No contacts present to perform deletion operation\n");
		cp.searchContactWithLastName(SELECTLASTNAME, LASTNAME);
		int conCount = cp.getContactCountSize()-1;
		System.out.println("Total contact count of "+LASTNAME+" before deletion operation: "+conCount);
		Assert.assertTrue(conCount>=1,"No contact found with lastname "+LASTNAME+"\n");
		cp.deleteAllByConfirming(driver);
		Thread.sleep(2000);
		//Step-7: Verify for contact deletion
		hp.clickOnContactsLink();
		Thread.sleep(2000);
		int afterConCount = cp.getContactCountSize()-1;
		System.out.println("Total contact count after search & deletion operation: "+afterConCount);
		Thread.sleep(2000);
		Assert.assertEquals(afterConCount, beforeConCount-conCount,"Delete operation of bulk contacts failed on contact with lastname "+LASTNAME+"\n");
		System.out.println("Bulk deletion of contact "+LASTNAME+" completed successfully");
	}
}
