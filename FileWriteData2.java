import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author harsh
 *
 */
public class FileWriteData2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		List<String> sentences = new ArrayList<String>();
		File file = new File("C:\\Users\\harsh\\\\MLdata\\trainNewdata.arff") ;
		String pathname = "C:\\Users\\harsh\\Desktop\\kako.txt";
		File file2 = new File(pathname);
		FileWriter fileWriter;
		fileWriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		// write in train data file for weka

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
		
		// TODO Auto-generated method stub

	}

}
