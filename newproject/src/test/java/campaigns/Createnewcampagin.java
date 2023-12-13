package campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import POMRepository.CreateCampaignsPage;
import POMRepository.Home1Page;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Createnewcampagin {

	@Test
	public void createCampaignTest() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		File_Utility flib=new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");

		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.logInToVtiger(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		Home1Page home=new Home1Page(driver);
		//home.clickMoreLink();
		//home.clickCampLink();
		
		/* WebElement moreLink = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		driver.findElement(By.linkText("Campaigns")).click();*/
		home.clickMoreLink(driver);
		
		CreateCampaignsPage camp=new CreateCampaignsPage(driver);
		camp.clickCampPlusimg();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String CampaginName = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
		camp.campaignsName(CampaginName);
		//driver.findElement(By.name("campaignname")).sendKeys(CampaginName);
	    
		camp.clickSaveButton();
	   // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
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
		home.logout(driver);
		 // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 // driver.findElement(By.linkText("Sign Out")).click();
	}

	
}

}
