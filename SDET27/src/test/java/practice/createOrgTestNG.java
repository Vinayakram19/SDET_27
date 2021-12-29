package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodisk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodisk.ObjectRepository.HomePage;
import com.crm.autodisk.ObjectRepository.OrganizationinfoPage;
import com.crm.autodisk.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)

public class createOrgTestNG extends BaseClass{

    @Test(groups = "SmokeSuite")
    
    public void createOrgTestNG() throws Throwable {
    	
    	SoftAssert sa = new SoftAssert();
    	
    	int ranDomNum = jLib.RanDomNumber(); 
    	
    	//read the data from excel file 
    	
    	String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomNum;
    	
    	//navigate to organization module
    	HomePage hp = new HomePage(driver);
    	hp.clickOnOrganizationsLinks();
    	sa.fail();
    	
    	//click on create organization button
    	OrganizationsPage op = new OrganizationsPage(driver);
    	op.clickoncreateOrg();
    	
    	//Enter all the details and create new organization
    	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
    	cop.createorg(orgName);
    	Assert.fail();
    	
    	//Verify organization name in header of mgs
    	OrganizationinfoPage oip = new OrganizationinfoPage(driver);
    	String act_Msg = oip.getOrgInfo();
    	
    	
    	/*
    	if(act_Msg.contains(orgName)) {
    		System.out.println(act_Msg);
    		System.out.println("Organization Created Successfully");
    	}else {
    		System.err.println("Failed");
    	}	
    */
    }
    
    
   @Test(groups = "SmokeSuite")
    public void Demo() {
    	
    	System.out.println("Demo");
    }

}



   
