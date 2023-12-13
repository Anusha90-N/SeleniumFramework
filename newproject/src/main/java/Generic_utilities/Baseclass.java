package Generic_utilities;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass<File_Utility> {

	public static WebDriver sdriver;

	public static void main(String[] args) {
		WebDriver driver;
		  WebDriver sdriver;
			public File_Utility flib = new File_Utility();
			
			@BeforeSuite(groups = {"SmokeTest","RegressionTest","SanityTest"})
		public void beforeSuite()
		{
			System.out.println("DataBase Connection");
		}
			@BeforeTest(groups = {"SmokeTest","RegressionTest","SanityTest"})
			public void beforeTest()
			{
				System.out.println("Parallel Execution Start");
			}
			
			//@Parameters("BROWSER")
			@BeforeClass(groups = {"SmokeTest","RegressionTest","SanityTest"})
			public void beforeClass() throws Throwable
			{
				File_Utility flib = new File_Utility();
			
				String BROWSER = flib.getKeyAndValue("browser");
			    if(BROWSER.equalsIgnoreCase("CHROME"))
				{
					WebDriverManager.chromedriver().setup();
					 driver=new ChromeDriver();
				}
			else if(BROWSER.equalsIgnoreCase("edge"))
				{
				WebDriverManager.edgedriver().setup();
				 driver=new EdgeDriver();
				}
				else
				{
					driver=new ChromeDriver();
				}
				
				System.out.println("Launch Browser");
				sdriver=driver;
			}
			@BeforeMethod(groups = {"SmokeTest","RegressionTest","SanityTest"})
			public void beforeMethod    throws Throwable
			{
				 File_Utility flib = new File_Utility();
					String URL = flib.getKeyAndValue("url");
					String USERNAME = flib.getKeyAndValue("username");
					String PASSWORD = flib.getKeyAndValue("password");
				
					driver.get(URL);
			        Thread.sleep(2000);
			        Login1Page login = new Login1Page(driver);
			    	login.loginToApplication(USERNAME, PASSWORD);
				System.out.println("Login to Application");
			}
			@AfterMethod(groups = {"SmokeTest","RegressionTest","SanityTest"})
			public void afterMethod()
			{
				 HomePage home1 = new HomePage(driver);
				 home1.Logout(driver);
				System.out.println("Logout application");
			}
			
			@AfterClass(groups = {"SmokeTest","RegressionTest","SanityTest"})
			public void afterClass()
			{
				//driver.quit();
				System.out.println("close Browser");
			}
			@AfterTest(groups = {"SmokeTest","RegressionTest","SanityTest"})
			public void afterTest()
			{
				System.out.println("parallel Execution done");
			}
			@AfterSuite(groups = {"SmokeTest","RegressionTest","SanityTest"})
			public void afterSuite()
			{
				System.out.println("DataBase Connection Close");
			}
		}

		
	}


