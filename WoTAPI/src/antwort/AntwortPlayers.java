package antwort;

import org.json.JSONArray;
import org.json.JSONObject;

public class AntwortPlayers extends Antwort {
	public AntwortPlayers(JSONObject antwortObject) {
		super(antwortObject);
	}

	@Override
	protected void verarbeiteImpl() {
		Object o = getJSONObject().get("data");
		if(o instanceof JSONArray) {
			JSONArray array = (JSONArray) o;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
