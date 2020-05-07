package thread;

import javafx.application.Platform;
import model.Race;
import ui.RaceControllerGUI;

public class ABBThread extends Thread {

	private Race race;
	private RaceControllerGUI controller;
	private String algorithmType;
	private String algorithmMode;
	private int n;
	private long t2;

	public ABBThread(Race race, RaceControllerGUI controller, String algorithmType, String algorithmMode, int n) {
		this.race = race;
		this.controller = controller;
		this.algorithmType = algorithmType;
		this.algorithmMode = algorithmMode;
		this.n = n;
	}

	public void run() {

		if (algorithmType.equalsIgnoreCase("ADD")) {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.addIterativeABB(n);
			} else {
				t2 = race.addRecursiveABB(n);
			}

		} else if (algorithmType.equalsIgnoreCase("SEARCH")) {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.queryIterativeABB(n);
			} else {
				t2 = race.queryRecursiveABB(n);
			}

		} else {

			if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
				t2 = race.deleteIterativeABB(n);
			} else {
				t2 = race.deleteRecursiveABB(n);
			}

		}

		Platform.runLater(new Thread() {
			@Override
			public void run() {
				controller.updateABBTime(t2);
			}
		});

	}
}
