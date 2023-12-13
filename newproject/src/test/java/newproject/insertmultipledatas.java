package newproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class insertmultipledatas {

	

	

	public static void main(String[] args) throws Throwable {
	WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
	
	 FileInputStream fes =new FileInputStream("./src/test/resources/Excel.xlsx");
	 
	 Workbook book=WorkbookFactory.create(fes);
	 
	 Sheet Sheet = book.getSheet("Sheet1");
	 
	 driver.get("https://www.amazon.in");
    List<WebElement> allLinks =driver.findElements(By.xpath("//a"));

int count=allLinks.size();
System.out.println(count);
for(int i=0; i< count; i++); 
{

	Row row=Sheet.createRow(i);
	
	Cell cell= (Cell) row.createCell(0);
	 
	cell.setCellValue(allLinks.get(i).getAttribute("href"));
	
	 
}
FileOutputStream fos=new FileOutputStream("src/test/resources/ExcelData1.xlsx");
book.write(fos);
book.close();

	}

}
