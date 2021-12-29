package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;

public class SampleTestTF extends BaseClass {
	
	@Test
	public void aaaa() {
		
		System.out.println("=========Test START========");
		
		Assert.assertEquals(false, true);
		
		System.out.println("========Test End==========");
	}

}
