package Pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.Excel_utility;

public class DataproviderEx {
	
	@Test(dataProvider="getData")
public void bookTickets(String src,String dest)
{
	System.out.println("Book tickets from "+src+" to"+dest+"");
	}
@DataProvider
public Object[][] getData() throws Throwable
{
	Excel_utility elib=new Excel_utility();
	Object[][] value=elib.getDataProvider("Dataprovider");
	return value;
}
}
