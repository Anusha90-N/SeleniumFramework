package newproject;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FetchingsingleDataFromExcel {



	public static void main(String[] args) throws Throwable {
		
	//Step1:-Set the path
	FileInputStream fes=new FileInputStream("./src/test/resources/Exceldata1.xlsx");
	//FileInputStream fes=new FileInputStream("C:\\Users\\Admin\\Documents\\Excel.xlsx");
	
	//step2:- open workbook in read mode
	Workbook book=WorkbookFactory.create(fes);
	
	//step3:-get control to the sheet
	 Sheet Sheet = book.getSheet("Firstdata");
	 
	 //step4:- get control on row
	 
	   Row row=Sheet.getRow(1);
	   
	   //Step5:-get control on cell
	   Cell cel = row.getCell(1);
	  
	   
	   String Exceldata1 = cel.getStringCellValue();
	  System.out.println("Exceldata1");
	   
	   
	}

}
