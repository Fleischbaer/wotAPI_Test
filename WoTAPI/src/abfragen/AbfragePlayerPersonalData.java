package abfragen;

public class AbfragePlayerPersonalData extends Abfrage {

	@Override
	protected String getBaselink() {
		return "https://api.worldoftanks.eu/wot/account/info/";
	}

	@Override
	protected String[] getMapKeysImpl() {
		String [] s = {"application_id",
				"account_id",
				"access_token",
				"extra",
				"fields",
				"language"};
		return s;
	}

}
