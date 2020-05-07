package thread;

import javafx.application.Platform;
import model.Race;
import ui.RaceControllerGUI;

public class ALThread extends Thread {

	private Race race;
	private RaceControllerGUI controller;
	private String algorithmType;
	private String algorithmMode;
	private int n;
	private long t2;

	public ALThread(Race race, RaceControllerGUI controller, String algorithmType, String algorithmMode, int n) {
		this.race = race;
		this.controller = controller;
		this.algorithmType = algorithmType;
		this.algorithmMode = algorithmMode;
		this.n = n;
	}
	
	public void run() {

		if (algorithmType.equalsIgnoreCase("ADD")) {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.addIterativeAL(n);
			} else {
				t2 = race.addRecursiveAL(n);
			}

		} else if (algorithmType.equalsIgnoreCase("SEARCH")) {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.queryIterativeAL(n);
			} else {
				t2 = race.queryRecursiveAL(n);
			}

		} else {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.deleteIterativeAL(n);
			} else {
				t2 = race.deleteRecursiveAL(n);
			}

		}

		Platform.runLater(new Thread() {
			@Override
			public void run() {
				controller.updateALTime(t2);
			}
		});

	}

}
