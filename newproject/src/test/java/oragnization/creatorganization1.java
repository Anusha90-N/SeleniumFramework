package oragnization;


import java.io.FileInputStream;
import java.util.Formatter;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_utilities.file_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class creatorganization1 {

	public static <File_Utility, Java_Utility> void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		/*FileInputStream fis = new FileInputStream("C:\\Users\\User\\Documents\\AdvSeleniumCommonData.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");*/
		

		//calling from File_Utility class
		file_utility flib=new file_utility();
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");

        driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizationtis")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

/*Random ran = new Random();
int ranNum = ran.nextInt(1000);*/

//calling from Java_Utility class
//Random Approach To avoid Duplicates
Java_Utility jlib=new Java_Utility();
int ranNum = jlib.getRandomNum();

//String OrgName = "TestYantra"+ranNum;
//fetching data from Excel
/*FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
Workbook book = WorkbookFactory.create(fes);
Sheet sheet = book.getSheet("Organization");
Row row = sheet.getRow(0);
Cell cel = row.getCell(0);
String OrgName = cel.getStringCellValue()+ranNum;*/

//calling from Excel_Utility class
Excel_Utility elib = new Excel_Utility();
//String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;
String OrgName = elib.getDataFormatterData("Organization", 0, 0)+ranNum;

driver.findElement(By.name("accountname")).sendKeys(OrgName);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(1000);
String PrdName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
if(PrdName.contains(OrgName))
{
	System.out.println("Organization Created");
}
else
{
	System.out.println("Organization not created");
}

driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();
	}

}
