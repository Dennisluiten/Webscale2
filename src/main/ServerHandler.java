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

public class ServerHandler {
	String teamid = "teamPancake";
	String password = "eb932e1586902b93a5ca86ff03d5aa90";
	
	public static void main(String[] args) {
		new ServerHandler().getContext(1, 1);

	}
	
	public ServerHandler (){
	}
	
	public DataPoint makeRequest(){		
		return null;
	}
	
	public DataPoint getContext(int i, int runid){
		String url = String.format("http://krabspin.uci.ru.nl/getcontext.json/?i=%d&runid=%d&teamid=%s&teampw=%s", i, runid, teamid, password);
		try {
			JSONObject json = readJSON(url);
			System.out.println(json.get("Language"));
			System.out.println(json);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	public JSONObject readJSON(String urlString) throws MalformedURLException, IOException, JSONException{
		InputStream is = new URL(urlString).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      json = json.getJSONObject("context");
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
