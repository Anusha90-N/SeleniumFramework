package Generic_utilities;

import java.util.Random;

public class java_uitility {

	/**
	 * This method is used to avoid duplicates
	 * @author Anusha
	 */
	
	public int getRaandom()
	{
	
	Random ran= new Random();
	int ranNum=ran.nextInt(1000);
	return ranNum;
	}
}
