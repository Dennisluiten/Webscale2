package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import enums.Language;
import enums.Platform;
import enums.SearchEngine;

public class ServerHandler {
	private static String teamid = "teamPancake";
	private static String password = "eb932e1586902b93a5ca86ff03d5aa90";
	
	public ServerHandler (){
	}
	
	public static void proposePage(DataPoint d){		
	    String url = String.format("http://krabspin.uci.ru.nl/proposePage.json/?i=%d&runid=%d&teamid=%s&teampw=%s&header=%d&adtype=%s&color=%s&productid=%d&price=%d", 
	    		d.i, d.runID, teamid, password, d.header, d.adtype, d.color, d.productID, d.price);
	    try {
			JSONObject json = readJSON(url, "effect");
			int success = Integer.parseInt(json.get("Success").toString());
			boolean b = false;
			if (success == 1)
				b = true;
			d.success = b;		
		} catch (IOException | JSONException e) {
			System.out.println("Deze exception handel ik (nog) niet af.");
			e.printStackTrace();
		}
	}
	
	public static DataPoint getContext(int i, int runid, boolean addRandom){
		DataPoint data = null;
		String url = String.format("http://krabspin.uci.ru.nl/getcontext.json/?i=%d&runid=%d&teamid=%s&teampw=%s", i, runid, teamid, password);
		try {
			
			JSONObject json = readJSON(url, "context");
//			System.out.println(json);
			Language l = Language.valueOf(json.getString("Language"));
			Platform p = Platform.valueOf(json.getString("Agent"));
			SearchEngine se = SearchEngine.valueOf(json.getString("Referer"));
			int userID = json.getInt("ID");
			int age = json.getInt("Age");
			data = new DataPoint(userID, p, l, age, se, runid, i, addRandom);
			
			
		}catch (IOException | JSONException e) {
			System.out.println("Deze exception handel ik (nog) niet af.");
			e.printStackTrace();
		}	
		return data;
	}
	
	/**
	 * 
	 * @param urlString
	 * @param arg context of effect
	 * @return 
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws JSONException
	 */
	private static JSONObject readJSON(String urlString, String arg) throws MalformedURLException, IOException, JSONException{
//		System.out.println(urlString);
		InputStream is = new URL(urlString).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      json = json.getJSONObject(arg);
	      return json;
	    } finally {
	      is.close();
	    }
	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	
	
	
}
