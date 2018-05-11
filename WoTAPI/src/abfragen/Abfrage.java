package abfragen;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import utils.Utils;


public abstract class Abfrage {
	private static final String BASELINK = "baselink";
	private static final char ERSTER_CHAR = '?';
	private static final char UND_CHAR = '&';
	private static final char GLEICH_CHAR = '=';
	private Map<String,String> parameter;
	
	public Abfrage() {
		createMapKeys();
	}
	private void createMapKeys() {
		final Map<String,String> params = getParameter();
		params.put(BASELINK, getBaselink());
		for(String key : getMapKeysImpl()) {
			params.put(key, "");
		}
	}
	
	protected Map<String,String> getParameter(){
		if(parameter == null) {
			parameter = new HashMap<String,String>();
		}
		return parameter;
	}
	
	protected abstract String getBaselink();
	protected abstract String[] getMapKeysImpl();
	
	public void putParameter(String parameter, String wert) {
		final Map<String,String> params = getParameter();
		if(params.containsKey(parameter)) {
			params.put(parameter, wert);
		} else {
			throw new IllegalArgumentException("Parameter existiert nicht");
		}
	}
	
	public JSONObject getAntwort() {
		try {
			return Utils.getJSONFromString(Utils.getStringFromURL(createAbfrageString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private String createAbfrageString() {
		String abfrageString = "";
		final Map<String,String> params = getParameter();
		abfrageString+=params.get(BASELINK);
		boolean ersterWert=true;
		for(String param : params.keySet()) {
			if(!param.equals(BASELINK)
					&&params.get(param)!=null
					&&!params.get(param).isEmpty()) {
				if(ersterWert) {
					abfrageString+=ERSTER_CHAR;
					ersterWert=false;
				} else {
					abfrageString+=UND_CHAR;
				}
				abfrageString+=param+GLEICH_CHAR+params.get(param);
			}
		}
		return abfrageString;
	}
}
