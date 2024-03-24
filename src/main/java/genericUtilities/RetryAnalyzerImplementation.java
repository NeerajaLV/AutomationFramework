package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		int count=0;
		int retryCount=2;//manual analysis
		while(count<retryCount) {
			count++;
			return true;//retry
		}
		return false;//no retry
	}

}
