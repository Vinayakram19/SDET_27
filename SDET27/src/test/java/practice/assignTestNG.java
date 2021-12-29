package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class assignTestNG {
	
	
	@Test(dataProvider = "getData")
	
	public void readDataFromDataProviderTest(String Name, int qty, String type) {
		
		System.out.println("BusName---->"+Name+"---Set Avaiable--->"+qty+"-------Ac or NonAc----->"+type);
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] objArr = new Object[5][3];
		
		objArr[0][0] ="KPN";
		objArr[0][1]= 60;
		objArr[0][2]= "AC";
		
		objArr[1][0] ="SuperDx";
		objArr[1][1]= 36;
		objArr[1][2]= "AC";
		
		objArr[2][0] ="SRM";
		objArr[2][1]= 06;
		objArr[2][2]= "NON AC";
		
		objArr[3][0] ="VINAYAK";
		objArr[3][1]= 21;
		objArr[3][2]= "AC";
		
		objArr[4][0] ="TN";
		objArr[4][1]= 19;
		objArr[4][2]= "NON AC";
		
		return objArr;
		
		
	}

}
