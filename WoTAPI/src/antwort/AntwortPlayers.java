package antwort;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.AllSpieler;
import fachklassen.Spieler;

public class AntwortPlayers extends Antwort {
	public AntwortPlayers(JSONObject antwortObject) {
		super(antwortObject);
	}

	@Override
	protected void verarbeiteImpl() {
		Object o = getJSONObject().get("data");
		JSONArray array = (JSONArray) o;
		for(int i1=0;i1<array.length();i1++){
			Object o2 = array.get(i1);
			JSONObject obj2 = (JSONObject) o2;
			Long id = obj2.getLong("account_id");
			String nickname = obj2.getString("nickname");
			Spieler s = new Spieler();
			s.setAccount_id(id);
			s.setNickname(nickname);
			AllSpieler.getInstance().addSpieler(s);
		}
		
	}
}
