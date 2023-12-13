package newproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_utilities.file_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class readdatafromproperties {

	public static void main(String[] args) throws Throwable {
	//	WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		
		Properties pro=new Properties();
		pro.setProperty("username", "standard_user");
		pro.setProperty("password", "secret_sauce");
		pro.setProperty("url", "https://www.saucedemo.com/v1/");
		
		file_utility flib=new file_utility();
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		
		/*FileOutputStream fos=new FileOutputStream("./src/test/resources/commonData.properties.txt");
		pro.store(fos, "COMMONDATA");
		System.out.println("data written sucessfully");*/
		

	}

}
