import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

//import org.apache.commons.lang3.StringUtils;




public class SentenceExtractor 
{

	public static void main(String[] args) throws IOException, NullPointerException 
	{
		int i;
	
		
		File path = new File("C:\\Users\\harsh\\Downloads\\Ensemble Data\\task3");
		File[] files = path.listFiles();
		List<String> sentences = new ArrayList<String>();

			// sort the files in numerical order
			Arrays.sort(files, new Comparator<File>() 
			{
				@Override
				public int compare(File f1, File f2) {
					String s1 = f1.getName().substring(5, f1.getName().indexOf("."));
					String s2 = f2.getName().substring(5, f2.getName().indexOf("."));
					return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
				}
			});
			
			
			for (i = 0; i < 1; i++) 
			{
				if (files[i].isFile()) 
				{
//				    String Filename = 	files[i].getName();
//				    System.out.println(Filename);
//				    System.out.println(i);
//					
				    String sentence = readLineByLine(files[i].toString());
				    int x = sentence.indexOf("nif:isString   ");
					int start = x + 17;				
//					int end = sentence.indexOf(".\" .");
					int end = sentence.indexOf("\" .");
					
             		end = end - 1;
//					System.out.println(start);
//				
//					System.out.println(end);
				
					String data = sentence.substring(start, end);
					
					//String bc = StringUtils.substringBetween(sentence, "nif:isString    \"", "\" ."));
					System.out.println(data);
					sentences.add(data);
					System.out.println("--------------------------------");
					
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

	
	private static  void getResult(List<String> sentences)  throws IOException 
		
		{
		
		
			Map<String, Integer> port_vs_extractorMap = new HashMap<String, Integer>();
			port_vs_extractorMap.put("fox", 2222);
			port_vs_extractorMap.put("fred", 2223);
//			port_vs_extractorMap.put("spotlight", 2224);
			port_vs_extractorMap.put("cedric", 2225);
			port_vs_extractorMap.put("openIE", 2226);
			port_vs_extractorMap.put("sorookin", 2227);

			int portNumb[] = { 2222, 2223, 2225, 2226, 2227 };
			

			Map<String, String> foxRespMap = new HashMap<String, String>();
			Map<String, String> fredRespMap = new HashMap<String, String>();
//			Map<String, String> spotlightRespMap = new HashMap<String, String>();
			Map<String, String> cedricRespMap = new HashMap<String, String>();
			Map<String, String> openIERespMap = new HashMap<String, String>();
			Map<String, String> sorookinRespMap = new HashMap<String, String>();
		
			

			for (int i = 0; i < sentences.size(); i++) {
				
				

				// calling every extractors and getting outputs

				for (int j = 0; j < portNumb.length; j++) {
//				String _extractorURL = "http://localhost:"+ portNumb[j] + "/extractSimple?input=" + "abc def";
				String URL2 = java.net.URLEncoder.encode( sentences.get(i), "UTF-8").replace("+", "%20");
//					String _extractorURL = "http://localhost:"+ portNumb[j] + "/extractSimple?input=";
//				
				String _extractorURL = "http://localhost:"+ portNumb[j] + "/extractSimple?input=" + URL2;
					
//					String url2 = 
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(_extractorURL));	
					_extractorURL = "https://www.google.com/";

					URL url;
					try {
						url = new URL(_extractorURL);
//
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						System.out.println(url);
						con.setRequestMethod("GET");
//
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
						StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) 
						{

						response.append(inputLine);
						}
					in.close();

					// print result
						System.out.println(response.toString());
				if (j == 0) 
						{
						foxRespMap.put(sentences.get(i), response.toString());
						} 
//					else if (j == 1) 
//						{
//							fredRespMap.put(sentences.get(i), response.toString());
//						} 
//					else if (j == 2) 
//						{
//							spotlightRespMap.put(sentences.get(i), response.toString());
//						}
					else if (j == 3) 
						{
							cedricRespMap.put(sentences.get(i), response.toString());
						} 
					else if (j == 4) 
						{
							openIERespMap.put(sentences.get(i), response.toString());
						} 
//						else if (j == 5) 
//						{
//							sorookinRespMap.put(sentences.get(i), response.toString());
//						}

					}
//					
				catch (MalformedURLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		
		// TODO Auto-generated method stub
		
	}


	public static String readLineByLine(String filePath) 
	{
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) 
		{
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

}
