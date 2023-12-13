package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class file_utility {
	
	/**
	 * This method is used to fetch common  data in application
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	 public String getKeyAndValueData(String key) throws Throwable 
	
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		
		String value=pro.getProperty(key);
		return value;
	}

}
