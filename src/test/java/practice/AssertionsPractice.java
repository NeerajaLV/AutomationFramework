package practice;

//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	//preferred->hard assert to handle errors
	//soft assert continues execution even after failures and logs all failures at end
	//assertAll()-log assert failures
	//assertAll()-continues execution till end if all passes 
	//else even after failures continues till assertAll() appears and logs all failures
	/*
	@Test
	public void hardAssert() {
		String t="Hello";
		System.out.println("==Step-1==");
		System.out.println("==Step-2==");
		System.out.println("==Step-3==");
		//Assert.assertEquals(1,0);
		//Assert.assertEquals("i", "I");
		//Assert.assertTrue(t.contains("p"));
		//Assert.assertSame(1,1);
		//Assert.fail(t);
		System.out.println("==Step-1==");
		System.out.println("==Step-2==");
		System.out.println("==Step-3==");
	}
	*/
	@Test
	public void softAssert() {
		SoftAssert sa=new SoftAssert();
		String t="Hello";
		System.out.println("==Step-1==");
		System.out.println("==Step-2==");
		System.out.println("==Step-3==");
		sa.assertEquals(1,1);
		sa.assertAll();
		sa.assertEquals("i", "I");
		sa.assertTrue(t.contains("o"));
		sa.assertAll();
		sa.assertSame(1,1);
		sa.fail(t);
		System.out.println("==Step-4==");
		System.out.println("==Step-5==");
		System.out.println("==Step-6==");
		sa.assertAll();//log assert failures
	}
}
