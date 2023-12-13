package campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_utilities.Excel_utility;
import Generic_utilities.file_utility;
import Generic_utilities.java_uitility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.LoginPage;

public class createcampagintest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	file_utility flib=new file_utility();
	String URL=flib.getKeyAndValueData("url");
	String USERNAME = flib.getKeyAndValueData("username");
	String PASSWORD = flib.getKeyAndValueData("password");
	driver.get(URL);
	//HardCoding
/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();*/
	
	//getter methods
/*	LoginPage login = new LoginPage(driver);
	login.getUserTextField().sendKeys(USERNAME);
	login.getPasswordTextField().sendKeys(PASSWORD);
	login.getLoginButton().click();*/
	
	//BusinessLogics
 LoginPage login = new LoginPage(driver);
 login.loginToApplication(USERNAME, PASSWORD);
			
			
WebElement moreLink = driver.findElement(By.linkText("More"));
Actions act = new Actions(driver);
act.moveToElement(moreLink).perform();
driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

java_uitility jlib=new java_uitility();
int ranNum=jlib.getRaandom();

/*Excel_utility elib=new Excel_utility();
CharSequence[] CampaginName =elib.getExcelDataUsingDataFormatter("Campagin", 0, 0)+ranNum;
driver.findElement(By.name("campaignname")).sendKeys(CampaginName);


driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
 Thread.sleep(2000);
 String Actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
if(Actdata.contains(CampaginName))
{
	System.out.println("pass");
	
}
else
{
	System.out.println("fail");
}
 Thread.sleep(2000);

 // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
 // driver.findElement(By.linkText("Sign Out")).click();
Object home;
((Object) home).Logout(driver);?*/
}

}