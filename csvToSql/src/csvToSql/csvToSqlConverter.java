package csvToSql;

import java.io.*;

public class csvToSqlConverter {

	public static void main (String s[]) throws IOException
	{
		File ipFile = new File("immigrants_by_nationality.csv");
		File opFile = new File("immigrants_by_nationality.sql");
		
		try {		Convert(ipFile,opFile);		}
		finally		{}
				
	}
	
	public static void Convert(File source , File dest) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(source) );
		Writer out = new BufferedWriter(new FileWriter(dest));

			String tuple = null;
			String[] myString = null;
			            
            in.readLine(); // for schema head mentioned in datasets
            
			while ((tuple = in.readLine()) != null )
			{
				
				myString = tuple.replace("\'","\'\'").split(",");
				out.write("INSERT INTO barcelona_data_sets.immigrants_by_nationality VALUES(" + myString[0] + "," + myString[1] + ",\'" + myString[2] + "\'," + myString[3] + ",\'" + myString[4] + "\',\'" + myString[5] 
						+ "\'," + myString[6] +" );\n");

			}

			in.close();
			out.close();
		
	}
}


// year smallint,DistrictCode smallint, DistrictName VARCHAR(50),NeighborhoodCode smallint, NeighborhoodName VARCHAR(50), Nationality TEXT, Number smallint