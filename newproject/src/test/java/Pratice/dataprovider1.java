package Pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider1 {
@Test(dataProvider="dataprovider_BookTicketTest")
	public void booktickets(String src,String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest+"" );
	}

@DataProvider
public Object[][] dataprovider_BookTicketTest()
{
	Object[][] obj=new Object[2][2];
obj[0][0]="Bangalore";
obj[0][1]="goa";

obj[1][0]="Bangalore";
obj[1][1]="mumbai";
return obj;
}
}
