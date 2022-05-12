package json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestJson {

	public static void main(String[] args) {
		try {
			JSONObject obj = (JSONObject) new JSONParser().parse(new FileReader("jsonFiles/exemple.json"));
			System.out.println(obj.get("nom") + ", " + obj.get("prenom"));
			JSONArray modules = (JSONArray) obj.get("modules");
			for (Object m : modules) {
				JSONObject jsonObj = (JSONObject) m;
				System.out.println(" - nom du module : " + jsonObj.get("nom") + ", durée : " + jsonObj.get("duree"));
			}
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
