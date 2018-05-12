package controller;

public class Controller {
	private Controller() {
		
	}
	private static class InstanceHolder {
		private static final Controller INSTANCE = new Controller();
	}
	public static Controller getInstance() {
		return InstanceHolder.INSTANCE;
	}
}
