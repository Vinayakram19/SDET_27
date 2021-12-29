package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author VINAYAKARAM J
 *
 */

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	
	public String getPropertiesKeyValue(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/data.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(Key);
		return value;
		
	}

}
