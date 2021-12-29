package practice;

import static org.testng.Assert.fail;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodisk.ObjectRepository.ContactsInfoPage;
import com.crm.autodisk.ObjectRepository.ContactsPage;
import com.crm.autodisk.ObjectRepository.CreateContactpage;
import com.crm.autodisk.ObjectRepository.HomePage;

public class CreateContectTestNG extends BaseClass{
	
	
	@Test(groups = "SmokeSuite")
	
	public void CreateContect() throws Throwable {
		
		int ranDomnum = jLib.RanDomNumber();
		
		//get data from excel
		String ConNAME = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomnum;	
		String lastn = eLib.getDataFromExcel("Sheet1", 10, 3);
		
		//navigate to organization module
    	HomePage hp = new HomePage(driver);
    	hp.clickOnContactsLinks();
    	Reporter.log("create on contacts",true);
    	
    	//click on create Contact button
    	ContactsPage cp =  new ContactsPage(driver);
    	cp.clickoncreateCon();
    	
    	//Enter all the details and create new Contact
    	CreateContactpage ccp = new CreateContactpage(driver);
    	ccp.createContact(lastn);
    	
    	//Verify Contact name in header of mgs	
    	ContactsInfoPage cip =  new ContactsInfoPage(driver);
    	String Act_mgs = cip.getcontactInfo();
    //	Assert.fail();
    	/*
    	if(Act_mgs.contains(lastn)) {
    		System.out.println(Act_mgs);
    		System.out.println("Contacts created Successfully");
    	}else {
    		System.err.println("Failed");
    	*/
    	
    	Assert.assertTrue(Act_mgs.contains(lastn));
    	
    	System.out.println("contact create sucussfully");
    		
		
	}

}
