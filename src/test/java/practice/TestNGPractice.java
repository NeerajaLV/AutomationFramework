package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	/*//Default order->ASCII value
	@Test
	public void createCustomer() {
		System.out.println("create");
	}
	@Test
	public void modifyCustomer() {
		System.out.println("modify");
	}
	@Test
	public void deleteCustomer() {
		System.out.println("delete");
	}
	*/
	/*//order->priority
	@Test(priority=-1)
	public void pmodifyCustomer() {
		System.out.println("pmodify");
	}
	@Test(priority=0)
	public void pcreateCustomer() {
		System.out.println("pcreate");
	}
	@Test(priority=1)
	public void pdeleteCustomer() {
		System.out.println("pdelete");
	}
	*/
	/*
	 * invocationCount = value
	 * minimum execution number of times is 1 
	 * any non zero n value - test script is not included in execution(Total tests runs),
	 * enables execution, executes n times
	 * <=zero value - disables execution
	 */
	/*
	@Test(invocationCount=-1)
	public void pmodifyCustomer() {
		System.out.println("pmodify");
	}
	@Test(invocationCount=0)
	public void pcreateCustomer() {
		System.out.println("pcreate");
	}
	@Test(invocationCount=3)
	public void pdeleteCustomer() {
		System.out.println("pdelete");
	}
	@Test
	public void pdeleteCustomer1() {
		System.out.println("pdelete1");
	}
	*/
	/*
	 * enabled=true/false
	 * false-test script is not included in execution(Total tests runs)
	 * true-vice versa
	 */
	/*
	@Test(enabled=true)
	public void pmodifyCustomer() {
		System.out.println("pmodify");
	}
	@Test(enabled=true)
	public void pcreateCustomer() {
		System.out.println("pcreate");
	}
	@Test(enabled=false)
	public void pdeleteCustomer() {
		System.out.println("pdelete");
	}
	*/
	/*
	 * dependsOnMethods="methodName", dependsOnMethods={"methodName1", "methodName2"}
	 * methodNmae is the method to executed prior to the current method specified
	 * executes when prior method passes
	 * skips when prior method fails
	 */
	@Test(dependsOnMethods="pcreateCustomer")
	public void pmodifyCustomer() {
		System.out.println("pmodify");
	}
	@Test
	public void pcreateCustomer() {
	Assert.fail();
		System.out.println("pcreate");
	}
	@Test(dependsOnMethods="pmodifyCustomer")
	public void pdeleteCustomer() {
		System.out.println("pdelete");
	}
	
}

