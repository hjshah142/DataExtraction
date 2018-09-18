
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class TraininigFileWriter 
{
	public static void main(String[] args)
	{
//		List<String> sentences = new ArrayList<String>();
		File file = new File("C:\\Users\\harsh\\\\MLdata\\trainNewdata2.arff") ;	
		FileWriter fileWriter;
		try 
		{
			fileWriter = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write("@relation DataExtraction2");
			bw.newLine();
			bw.write("@ATTRIBUTE Sentence	string");
			bw.newLine();
			bw.write("@ATTRIBUTE Foxoutput	string");
			bw.newLine();
			bw.newLine();
			bw.write("@ATTRIBUTE OPENIEoutput	string");
			bw.newLine();
			bw.write("@data");
			bw.newLine();
			bw.close();
			fileWriter.close();
			System.out.println("File Created and closed");
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// write in train data file for weka
		
	}

}
