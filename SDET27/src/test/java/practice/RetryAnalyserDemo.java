package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {

	@Test(retryAnalyzer = com.crm.autodesk.genericutility.RetryAnalyserImpl.class)
	
	public void retryAnalyser() {
		
		System.out.println("RetryAnalyser");
		Assert.fail();
	}
	
	
}
