
import java.io.*;
import java.sql.*;

public class bulkJdbcInsert {

	public static void main (String s[]) throws IOException, ClassNotFoundException, SQLException
	{
		try {		bulkInsertJDBC();		}
		finally		{}
				
	}
	
	public static void bulkInsertJDBC() throws IOException, ClassNotFoundException, SQLException
	{
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/dbmsAssignment_db", "postgres","1234");
			            
         //   connection.createStatement().executeUpdate("COPY barcelona_data_sets.immigrants_by_nationality FROM 'D:\\Study\\IITD IInd Semester\\COL 632\\barcelona-data-sets\\immigrants_by_nationality.csv' with CSV HEADER;");
            connection.createStatement().executeUpdate("DELETE FROM barcelona_data_sets.immigrants_by_nationality;");
			
		
	}
}
