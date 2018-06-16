import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class SentenceFinder 
{

	public static void main(String[] args) throws IOException 
	{
			File path = new File("C:\\Users\\harsh\\Downloads\\Ensemble Data\\task3");
			File[] files = path.listFiles();
//			List<String> sentences = new ArrayList<String>();

			// sort the files in numerical order
//			Arrays.sort(files, new Comparator<File>() 
//			{
//				@Override
//				public int compare(File f1, File f2) 
//				{
//					String s1 = f1.getName().substring(5, f1.getName().indexOf("."));
//					String s2 = f2.getName().substring(5, f2.getName().indexOf("."));
//					return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
//				}
//			});

			for (int i = 0; i < files.length; i++) 
			{
				if (files[i].isFile()) 
				{
					String sentence = readLineByLine(files[i].toString());
					sentences.add(StringUtils.substringBetween(sentence, "nif:isString    \"", "\" ."));
				}
			}
					try  
			{
				getResult(sentences);
			} catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub

	}


obtainSentencefromFiles(String)
