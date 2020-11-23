package com.Sandar.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExcelExportController {

	@RequestMapping(value="/exportExcel", method=RequestMethod.GET)
	public @ResponseBody void exportexcel() throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadSheet = workbook.createSheet("Sandar Linn");
		
//		CellRangeAddressList addressList = new CellRangeAddressList(
//			    1, 1, 7, 7);
//		System.out.println("addressList");
//			  DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(
//			    new String[]{"10", "20", "30"});
//			  
//			  System.out.println("dv constraint");
//			  DataValidation dataValidation = new HSSFDataValidation
//			    (addressList, dvConstraint);
//			  
//			  System.out.println("dataValidation");
//			  
//			  dataValidation.setSuppressDropDownArrow(true);
//			  System.out.println("setSuppressDropDownArrow");
//			 // spreadSheet.addValidationData(dataValidation);
			  System.out.println("addValidationData");
			  
		XSSFRow row ;
		Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
		empinfo.put( "1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
		empinfo.put( "2", new Object[] { "tp01", "Gopal", "Technical Manager" });
		empinfo.put( "3", new Object[] { "tp02", "Manisha", "Proof Reader" });
		empinfo.put( "4", new Object[] { "tp03", "Masthan", "Technical Writer" });
		empinfo.put( "5", new Object[] { "tp04", "Satish", "Technical Writer" });
		empinfo.put( "6", new Object[] { "tp05", "Krishna", "Technical Writer" });
		
		System.out.println("hello");

		 Set < String > keyid = empinfo.keySet();
	      int rowid = 0;

	      for (String key : keyid) {
	    	  spreadSheet.setColumnWidth(rowid, 4000);
	         row = spreadSheet.createRow(rowid++);
	         Object [] objectArr = empinfo.get(key);
	         int cellid = 0;

	         for (Object obj : objectArr) {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      
	      FileOutputStream out = new FileOutputStream(new File("Writesheet1.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("Writesheet.xlsx written successfully");
	  
	}
	
	@RequestMapping(value="/exportForExcel", method=RequestMethod.GET)
	public @ResponseBody void exportForExcel() throws IOException{
		  HSSFWorkbook workbook = new HSSFWorkbook();
		  HSSFSheet sheet = workbook.createSheet("Data Validation");
		  CellRangeAddressList addressList = new CellRangeAddressList(
		    0, 0, 0, 0);
		  DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(
		    new String[]{"10", "20", "30"});
		  DataValidation dataValidation = new HSSFDataValidation
		    (addressList, dvConstraint);
		  dataValidation.setSuppressDropDownArrow(false);
		  sheet.addValidationData(dataValidation);
	  
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/readFromExcel", method=RequestMethod.GET)
	public @ResponseBody void readFromExcel() throws IOException{
		FileInputStream file = new FileInputStream(new File("Writesheet.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		 
		Map<Integer, List<String>> data = new HashMap<>();
		int i = 0;
		
		for (Row row : sheet) {
		    data.put(i, new ArrayList<String>());
		    for (Cell cell : row) {
		        switch (cell.getCellTypeEnum()) {
		            case STRING: data.get(i).add(cell.getStringCellValue() + ""); break;
		            case NUMERIC: data.get(i).add(cell.getNumericCellValue() + ""); break;
		            case BOOLEAN: data.get(i).add(cell.getBooleanCellValue() + ""); break;
		            default: data.get(new Integer(i)).add(" ");
		        }
		    }
		    i++;
		}
		
		for(Map.Entry<Integer, List<String>> entry : data.entrySet()) {
			List<String> result = entry.getValue();
			for(String st : result) {
				System.out.print(st + "  : ");
			}
			System.out.println();
		}
	}
	
	
}
