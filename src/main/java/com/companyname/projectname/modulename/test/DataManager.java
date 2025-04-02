package com.companyname.projectname.modulename.test;

import java.util.ArrayList;
import java.util.Hashtable;

public class DataManager {

	public String excelpath;
	
	public DataManager(String excelpath) {
		this.excelpath = excelpath;	
	}
	
	public Hashtable<String, String> getRunMode(String sheetName, String testcaseName_column, String run_Mode_column) {
		Hashtable<String, String> run_mode = new Hashtable<>();
		ExcelReader excel = new ExcelReader(excelpath);
		
		int rows = excel.getRowCount(sheetName);
		System.out.println("rows count: " +rows);
	
		for(int i = 2; i<=rows ; i++) {		
		String key = excel.getCellData(sheetName, testcaseName_column, i);		
		String value = excel.getCellData(sheetName, run_Mode_column, i);	
		run_mode.put(key, value);
		}
		
		System.out.println("HashTable Run Mode :- " +run_mode);
		return run_mode;
	}
	

	public Hashtable<Object, Object> getTestDataInHashTable(String sheetName, String TestCaseName) {

		ExcelReader excel = new ExcelReader(excelpath);

		int rows = excel.getRowCount(sheetName);
		System.out.println("rows count: " + rows);

		int col = excel.getColumnCount(sheetName);
		System.out.println("col count: " + col);

		ArrayList<String> header = new ArrayList<String>();
		ArrayList<String> tc_data = new ArrayList<String>();

		Hashtable<Object, Object> ht = new Hashtable<Object, Object>();

		System.out.println("*****Test Data for Test TC "+TestCaseName);
		for (int j = 0; j <= col; j++) {
			header.add(excel.getCellData(sheetName, j, 1));
		}
		//System.out.println(header);

		//System.out.println("######## Getting Test Data ##########");
		for (int i = 2; i <= rows; i++) {
			for (int j = 0; j <= col; j++) {
				if (!excel.getCellData(sheetName, 0, i).equalsIgnoreCase(TestCaseName))
					break;
				tc_data.add(excel.getCellData(sheetName, j, i));
			}

		}
		//System.out.println(tc_data);

		for (int k = 0; k < header.size(); k++) {
			ht.put(header.get(k), tc_data.get(k));
		}
		System.out.println(ht);
		
		return ht;

	}

}
