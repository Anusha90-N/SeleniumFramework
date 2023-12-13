package Pratice;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ptc {
RemoteWebDriver driver;
@Test
public void M1Test(URL url) throws Throwable
{
	URL url1=new URL("htpp://192.168.0.114:4444/wd/hub");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.WINDOWS);
	
	driver=new RemoteWebDriver(url1, cap);
	driver.get("https://www.amazon.in/");
	}
}

