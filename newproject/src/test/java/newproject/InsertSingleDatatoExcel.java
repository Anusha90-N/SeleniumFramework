package newproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class InsertSingleDatatoExcel {

	public static void main(String[] args) throws Throwable {
		
		
			//Step1:-Set the path
		FileInputStream fes = new FileInputStream("./src/test/resources/Excel.xlsx");
		
		         //step2:-Open WorkBook in read mode
			Workbook book = WorkbookFactory.create(fes);
			     
			//step3:-get control to the sheet
			Sheet sheet = book.getSheet("ExcelData");
			
			Row row = sheet.createRow(0);

			Cell cel1 = row.createCell(0);
			
			cel1.setCellValue("TestYantra");
			
			
			FileOutputStream fos = new FileOutputStream("./src/test/resources/Excel.xlsx");
			book.write(fos);
			book.close();

		
		
		
	}

}
