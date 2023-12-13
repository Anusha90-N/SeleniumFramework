package oragnization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createoragnization {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("http://localhost:8888");
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();


driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
String Name="jspiders";
driver.findElement(By.name("accountname")).sendKeys("jspiders");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(2000);
 String orgName= driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

if (orgName.contains(Name)) {
	

	System.out.println("Organization Created");
}
else
{
	System.out.println("Organization not Created");
	}
Thread.sleep(2000);
driver.findElement(By.xpath("//img[@ src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	



	}

}
