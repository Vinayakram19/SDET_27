package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author VINAYAKARAM J
 *
 */

     public class JavaUtility {
/**
 * its used to return random number
 * @return int data
 */
	 public int RanDomNumber(){
		Random random = new Random();
		int intrandom =random.nextInt(10000);
		return intrandom;	
		
	}
	/**
	 * its used to get System Date And Time in IST format
	 * @return
	 */

      public String getSystemDateAndTime() {
    	  Date date= new Date();
		return date.toString();    
    	  
      }
      /**
       * its used to get System Date With Format in IST format
       * @return
       */
	
       public String getSystemDateWithFormat() {
    	  
    	  Date date = new Date();
    	  String DateAndTime = date.toString();
          String YYYY = DateAndTime.split(" ")[5];
    	  String DD = DateAndTime.split(" ")[2];
    	  int MM = date.getMonth()+1;
    	  
    	  String finalFormat = YYYY+"-"+MM+"-"+DD;
    	  /*
    	 System.out.println(finalFormat);
		System.out.println(YYYY.substring(1,3));
		*/
		return finalFormat;
		
    	  
    	  
      }
}

