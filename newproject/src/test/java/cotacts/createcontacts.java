package cotacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createcontacts {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("http://localhost:8888");
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.linkText("Contacts")).click();
driver.findElement(By.cssSelector("a[href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']")).click();

driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Anusha");
driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nettam");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

String contactName= driver.findElement(By.xpath("//span[@id=\'dtlview_First Name\']")).getText();


if(contactName.contains(contactName)){
	

	System.out.println("contact Created");
}
else
{
	System.out.println("contact not Created");
	}

Thread.sleep(2000);
driver.findElement(By.xpath("//img[@ src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	









	}

}
