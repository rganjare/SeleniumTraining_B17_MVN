package com.companyname.projectname.modulename.test;

public class ExcelReading {

	public static void main(String[] args) {
		
		ExcelReader excel = new ExcelReader("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\Selenium_Training_B17_MVN\\src\\main\\resources\\files\\Test_Data.xlsx");
		
		//System.out.println(excel.addSheet("Test_Data_UAT"));
		
		//System.out.println(excel.addColumn("Test_Data_SIT", "Mobile_No"));
		
		//System.out.println(excel.removeColumn("Test_Data_SIT", 7) );
		
	//	excel.setCellData("Test_Data_SIT", "Mobile_No", 2, "9850123456");
		
		//System.out.println(excel.getCellData("Test_Data_SIT", "Password", 4));
		
		System.out.println(excel.getCellData("Test_Data_SIT", "Last_Name", 3));
		
	}

}
