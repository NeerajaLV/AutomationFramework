package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzer {
	@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
	public void testMethod() {
		Assert.fail();
		System.out.println("Hello");
	}
}
