import java.io.*;
import java.sql.*;

public class singleJDBCInsert {

	public static void main (String s[]) throws IOException, ClassNotFoundException, SQLException
	{
		File ipFile = new File("immigrants_by_nationality.csv");
		
		try {		singleInsertJDBC(ipFile);		}
		finally		{}
				
	}
	
	public static void singleInsertJDBC(File source) throws IOException, ClassNotFoundException, SQLException
	{
		BufferedReader in = new BufferedReader(new FileReader(source) );
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/dbmsAssignment_db", "postgres","1234");
			 
				
			String tuple = null;
			String[] myString = null;
			            
            in.readLine(); // for schema head mentioned in datasets
            
			while ((tuple = in.readLine()) != null )
			{
				Statement stmt;				
				myString = tuple.replace("\'","\'\'").split(",");		
				connection.createStatement().executeUpdate("INSERT INTO barcelona_data_sets.immigrants_by_nationality VALUES( "+  myString[0]   + " , " +  myString[1]  + ", '" +  myString[2]  + "'  , "+  myString[3]  + ", '" + myString[4] + "', '"+ myString[5] + "', "+ myString[6] + " ) ");     
				
			}
			
            
			
		
	}
}
