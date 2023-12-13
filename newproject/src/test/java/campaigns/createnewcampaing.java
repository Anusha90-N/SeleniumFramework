package campaigns;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_utilities.java_uitility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createnewcampaing {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("http://localhost:8888");
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

java_uitility jlib=new java_uitility();
int ranNum=jlib.getRaandom();

/*Random ran=new Random();
int ranNum=ran.nextInt(1000);*/

String Name="iphone"+ranNum;
driver.findElement(By.name("productname")).sendKeys(Name);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(2000);
 String ProductName= driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

if (ProductName.contains(Name)) {
	

	System.out.println("Product Created");
}
else
{
	System.out.println("product not Created");
	}



driver.findElement(By.linkText("More")).click();
driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
driver.findElement(By.xpath("//img[@alt='Select']")).click();
Set<String> windows=driver.getWindowHandles();
Iterator<String>window=windows.iterator();

while (window.hasNext()) 
{
	
String windowText=window.next();
driver.switchTo().window(windowText);
String title=driver.getTitle();

title.contains("Products&action");
break;
	
}
driver.findElement(By.name("search_text")).sendKeys(Name);
driver.findElement(By.xpath("//input[@name='search']")).click();
driver.findElement(By.xpath("//a[text()='"+Name+"']")).click();

	}
}

	
	


