package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Excel_utility {
	/**
	 * this method is used to fetch data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Anusha
	 */

	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/Excel.xlsx");
		Workbook book= WorkbookFactory.create(fes);
		Sheet sheet=book.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cel=row.getCell(cellNum);
		String ExcelData=cel.getStringCellValue();
		return ExcelData;
		

	}
	public String getDataFormatteDatar(String sheetName,int rowNum,int cellNum) throws Throwable
	
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/Excel.xlsx");
		Workbook book= WorkbookFactory.create(fes);
		Sheet sheet=book.getSheet(sheetName);
	  Row  row=sheet.getRow(rowNum);
		Cell cell=row.getCell(cellNum);

		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		return ExcelData;
		
	}
	public Object[][] getDataProvider(String sheetName) throws Throwable
	{
		
		FileInputStream fes =new FileInputStream("./src/test/resources/ExcelDataprovider.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheet=book.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum()+1;
		short lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow][lastCell];
		
		for (int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	}

		
		
		

