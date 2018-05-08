package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import utils.Utils;

class UtilsTest {

	@Test
	void testStringFromURL() {
		try {
			Utils.getStringFromURL("https://github.com/Fleischbaer/wotAPI_Test");
			Utils.getStringFromURL("https://api.worldoftanks.eu/wot/account/list/?application_id=demo&search=fleischbaer");
		} catch (IOException e) {
			fail("Error entstanden");
			e.printStackTrace();
		}
	}
	
	@Test
	void testJSONFromString() {
		try {
			Utils.getJSONFromString(Utils.getStringFromURL("https://api.worldoftanks.eu/wot/account/list/?application_id=demo&search=fleischbaer"));
		} catch (IOException e) {
			fail("Error entstanden");
			e.printStackTrace();
		}
	}

}
