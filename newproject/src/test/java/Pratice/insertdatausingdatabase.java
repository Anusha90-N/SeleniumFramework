package Pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class insertdatausingdatabase {

public static void main(String[] args) throws Throwable {
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
			
Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root" );
Statement state=conn.createStatement();
String query ="insert into qspiders(first_name,last_name,address)values('ram','sam','goa')";
int result=state.executeUpdate(query);
if (result==1)
{
	System.out.println("Data is updated");
	
}
else {
	System.out.println("Data is not updated");
}


		
	}

}
