package Generic_utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Webdriver_utility {

private Object window;

public void maximizingWindow(WebDriver driver)	
{
	driver.manage().window().maximize();
	
}
	 
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void implicity_Wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void windoSwitching(WebDriver driver,String partialVisibleText)
	{
		Set<String>allWin=driver.getWindowHandles();
		
		
		while (window.hasNext()) 
		{
			
		String windowText=window.next();
		driver.switchTo().window(windowText);
		String title=driver.getTitle();

if(title.contains(partialVisibleText))
{
	break;
}
	}
}

}
	

