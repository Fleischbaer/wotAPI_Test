package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Utils {
	public static String getStringFromURL(String urlString) throws IOException {
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
		String gesamtString = "";
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			gesamtString+=in.readLine()+"\n";
			System.out.println(inputLine);
		}
		in.close();
		return gesamtString;
	}
}
