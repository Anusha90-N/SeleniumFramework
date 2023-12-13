package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createproduct {
@Test
	public void test1() { throws Throwable {
		WebDriverManager.edgedriver().setup();
 		WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888");
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();


driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
String Name="iphone";
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
Thread.sleep(2000);
driver.findElement(By.xpath("//img[@ src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	

	


	

}
}