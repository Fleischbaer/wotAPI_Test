package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class Utils {
	public static String getStringFromURL(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
		String gesamtString = "";
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			gesamtString+=inputLine+"\n";
		}
		in.close();
		return gesamtString;
	}
	
	public static JSONObject getJSONFromString(String jsonString) {
		return new JSONObject(jsonString);
	}
}
