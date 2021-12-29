package practice;

import java.util.Date;

public class GetSystemDate {
	public static void main(String[] args) {
		
		Date date = new Date();
		String DateAndTime = date.toString();
		System.out.println(DateAndTime);
		String YYYY = DateAndTime.split(" ")[5];
		String DD = DateAndTime.split(" ")[2];
		int MM = date.getMonth();
		String FinalFormat = YYYY+"-"+DD+"-"+MM;
		System.out.println(FinalFormat);
		System.out.println(YYYY.substring(2,4));
		
	}

}
