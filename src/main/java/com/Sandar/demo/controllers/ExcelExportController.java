package com.Sandar.demo.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
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
		XSSFRow row ;
		Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
		empinfo.put( "1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
		empinfo.put( "2", new Object[] { "tp01", "Gopal", "Technical Manager" });
		empinfo.put( "3", new Object[] { "tp02", "Manisha", "Proof Reader" });
		empinfo.put( "4", new Object[] { "tp03", "Masthan", "Technical Writer" });
		empinfo.put( "5", new Object[] { "tp04", "Satish", "Technical Writer" });
		empinfo.put( "6", new Object[] { "tp05", "Krishna", "Technical Writer" });

		 Set < String > keyid = empinfo.keySet();
	      int rowid = 0;

	      for (String key : keyid) {
	         row = spreadSheet.createRow(rowid++);
	         Object [] objectArr = empinfo.get(key);
	         int cellid = 0;

	         for (Object obj : objectArr) {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      
	      FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("Writesheet.xlsx written successfully");
	      
		
	}
}
