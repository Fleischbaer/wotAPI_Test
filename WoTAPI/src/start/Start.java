package start;

import org.json.JSONObject;

import abfragen.AbfragePlayerPersonalData;
import abfragen.AbfragePlayers;
import gui.Hauptfenster;

public class Start {

	public static void main(String[] args) {
		new Hauptfenster();
		AbfragePlayers abfrage = new AbfragePlayers();
		abfrage.putParameter("application_id", "demo");
		abfrage.putParameter("search", "Fleischbaer");
		abfrage.putParameter("type", "exact");
		JSONObject json = abfrage.getAntwort();
		System.out.println(json);
		AbfragePlayerPersonalData abfrage2 = new AbfragePlayerPersonalData();
		abfrage2.putParameter("application_id", "demo");
		abfrage2.putParameter("account_id", ((JSONObject)((org.json.JSONArray)json.get("data")).get(0)).get("account_id").toString());
		System.out.println(abfrage2.getAntwort());
	}

}
