package abfragen;

public class AbfrageWoTPlayers extends Abfrage {

	@Override
	protected String getBaselink() {
		return "https://api.worldoftanks.eu/wot/account/list/";
	}

	@Override
	protected String[] getMapKeysImpl() {
		String [] s = {"application_id", 
				"search",
				"fields",
				"language",
				"limit",
				"type"};
		return s;
	}

}
