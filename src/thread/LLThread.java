package thread;

import javafx.application.Platform;
import model.Race;
import ui.RaceControllerGUI;

public class LLThread extends Thread{
	
	private Race race;
	private RaceControllerGUI controller;
	private String algorithmType;
	private String algorithmMode;
	private int n;
	private long t2;

	public LLThread(Race race, RaceControllerGUI controller, String algorithmType, String algorithmMode, int n) {
		this.race = race;
		this.controller = controller;
		this.algorithmType = algorithmType;
		this.algorithmMode = algorithmMode;
		this.n = n;
	}
	
	public void run() {

		if (algorithmType.equalsIgnoreCase("ADD")) {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.addIterativeLE(n);
			} else {
				t2 = race.addRecursiveLE(n);
			}

		} else if (algorithmType.equalsIgnoreCase("SEARCH")) {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.queryIterativeLE(n);
			} else {
				t2 = race.queryRecursiveLE(n);
			}

		} else {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.deleteIterativeLE(n);
			} else {
				t2 = race.deleteRecursiveLE(n);
			}

		}

		Platform.runLater(new Thread() {
			@Override
			public void run() {
				controller.updateLETime(t2);
			}
		});

	}
}
