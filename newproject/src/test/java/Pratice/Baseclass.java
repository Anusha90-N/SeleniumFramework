package Pratice;

import java.net.URL;

import org.junit.BeforeClass;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;


public class Baseclass {
	RemoteWebDriver driver;
	@Parameters("BROWSER")
	@BeforeClass
	public void config( String BROWSER, URL url) throws Throwable
	
	{
		URL url1=new URL("htpp://192.168.0.114:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
		cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			}
		driver=new RemoteWebDriver(url1, cap);
		}
	
}
	

