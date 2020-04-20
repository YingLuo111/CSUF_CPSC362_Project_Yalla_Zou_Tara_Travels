import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import jave.net.URLCOnnection;
import sun.net.www.URLConnection;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;






public class WeatherRequest {
	
	public static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map= new Gson().fromJson(
			str, new TypeToken<HashMap<String, Object>>()  ().getType());
		return map;
	}
	
	public static void main(string[] args) {
		String API_KEY = "79b1e5c955fca00689bf8feb0e50b2b4";
		String LOCATION = getDestAirport(); // userEnter1.getText()
		String urlString = "api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid="+ API_KEY + "&units=imperial";
		try {
			StringBuilder result = new StringBuilder();	
				URL url = new (urlString);
				URLConnection conn = url.openConnection();
				BufferedReader rd = new BufferedReader (new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = rd.readLine())  != null )
				{
					result.append(line);
				}
				rd.close();
				System.out.println(result);
				
				
				Map<String, Object> respMap = jsonToMap (result.toString());
				Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
				Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
				
				System.out.println("Current temperature: " + mainMap.get("temp"));
				System.out.println("Current Humidity: " + mainMap.get("Humidity"));
				System.out.println("Wind Speeds: " + windMap.get("speed"));
				System.out.println("Wind Angle: " + windMap.get("deg"));
				
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
				
	}

}
