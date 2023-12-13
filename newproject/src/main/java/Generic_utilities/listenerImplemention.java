package Generic_utilities;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerImplemention implements ITestListener
{

	@SuppressWarnings("deprecation")
	public void onTestFailure(ITestResult result) {
		
	
		String testData=result.getMethod().getMethodName();
		
		Object BaseClass;
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshot/"+testData+".Png"));
			
		}catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		
	}
	
}