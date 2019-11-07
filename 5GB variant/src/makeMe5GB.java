
import java.io.*;
public class makeMe5GB {


	public static void main (String s[]) throws IOException
	{
		File ipFile = new File("immigrants_by_nationality.csv");
		File opFile = new File("immigrants_by_nationality1.csv");


		BufferedReader in = new BufferedReader(new FileReader(ipFile) );
		Writer out = new BufferedWriter(new FileWriter(opFile));

		String tuple = null;
		String[] myString = null;

		in.readLine(); // for schema head mentioned in datasets

		while ((tuple = in.readLine()) != null )
		{
			for(int i  = 0 ; i<120;i++)
				out.write(tuple);
			
			if(getFileSizeMegaBytes(opFile) > 6000.0) break;

		}

		in.close();
		out.close();

	}
	
	private static double getFileSizeMegaBytes(File file) {
		return (double) file.length() / (1024 * 1024);
	}

}

