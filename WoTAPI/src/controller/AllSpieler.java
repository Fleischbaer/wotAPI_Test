package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fachklassen.Spieler;

public class AllSpieler {
	private Set<Spieler> alleSpieler;
	
	private AllSpieler() {
	}
	private static class InstanceHolder {
		private static final AllSpieler INSTANCE = new AllSpieler();
	}
	public static AllSpieler getInstance() {
		return InstanceHolder.INSTANCE;
	}
	
	private Set<Spieler> getAlleSpielerPrivate(){
		if(alleSpieler == null) {
			alleSpieler = new HashSet<Spieler>();
		}
		return alleSpieler;
	}
	public List<Spieler> getAlleSpielerPublic(){
		return new ArrayList(getAlleSpielerPrivate());
	}
	public Spieler getSpielerById(Long id) {
		for(Spieler sp :getAlleSpielerPrivate()) {
			if(sp.getAccount_id().longValue()==id.longValue()) {
				return sp;
			}
		}
		return null;
	}
	public void addSpieler(Spieler sp) {
		getAlleSpielerPrivate().add(sp);
	}
}
