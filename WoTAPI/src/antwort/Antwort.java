package antwort;

import org.json.JSONObject;

public abstract class Antwort {
	private static final String STATUS_OK = "ok";
	private final JSONObject antwortObject;
	private boolean erfolgreich;
	public Antwort(JSONObject antwortObject) {
		this.antwortObject=antwortObject;
		verarbeite();
	}
	private void verarbeite() {
		Object status = getJSONObject().get("status");
		if(status instanceof String 
				&& status.equals(STATUS_OK)) {
			erfolgreich=true;
		}
		if(erfolgreich) {
			verarbeiteImpl();
		} else {
			throw new IllegalArgumentException();
		}
	}
	protected abstract void verarbeiteImpl();
	
	protected JSONObject getJSONObject() {
		return antwortObject;
	}
	
	
	
	public boolean isErfolgreich() {
		return erfolgreich;
	}
}
