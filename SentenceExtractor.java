import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExampleExtractor 
{

	public static void main(String[] args) throws IOException 
	{
		
//		int portNumb[] = { 2222, 2224, 2225, 2226, 2227 };
		int portNumb[] = { 2226, 2227 };
		String sentence = "Obama was born in usa";
		
		String URL2 = java.net.URLEncoder.encode( sentence, "UTF-8").replace("+", "%20");
		
		
		for (int j = 0; j < portNumb.length; j++) 
		{
		String _extractorURL = "http://localhost:"+ portNumb[j] + "/extractSimple?input=" + URL2;
		java.awt.Desktop.getDesktop().browse(java.net.URI.create(_extractorURL));
		
		
		    
		URL url;
		try 
			{
			url = new URL(_extractorURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) 
				{
				response.append(inputLine);
				}
			in.close();
			System.out.println("----Extractors --------------" + portNumb[j]  + " response");
			String response_string = response.toString();
				System.out.println(response.toString());
		// TODO Auto-generated method stub

			}
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
}
