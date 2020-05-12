package thread;

import model.Race;
import ui.RaceControllerGUI;

public class LLThread extends Thread {

	private Race race;
	private RaceControllerGUI controller;
	private String algorithmType;
	private String algorithmMode;
	private int n;
	
	private boolean lost = false;

	private ABBThread abbThread;
	private ALThread alThread;
	
	public LLThread(Race race, RaceControllerGUI controller, String algorithmType, String algorithmMode, int n, ABBThread abbThread, ALThread alThread) {
		this.race = race;
		this.controller = controller;
		this.algorithmType = algorithmType;
		this.algorithmMode = algorithmMode;
		this.n = n;
		
		this.abbThread = abbThread;
		this.alThread = alThread;
		
	}

	public void run() {
		
		UpdateThread updateThread = new UpdateThread(race, controller, n, abbThread, alThread, this);
		updateThread.start();
		
		try {
		
			if (algorithmType.equalsIgnoreCase("ADD")) {
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.addIterativeLE(n);
				
				} else {
					race.addRecursiveLE(n);
				}
	
			} else if (algorithmType.equalsIgnoreCase("SEARCH")) {
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.queryIterativeLE(n);
				} else {
					race.queryRecursiveLE(n);
				}
	
			} else {
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.deleteIterativeLE(n);
				} else {
					race.deleteRecursiveLE(n);
				}
	
			}
		}catch(StackOverflowError e) {
			lost = true;
			System.out.println("LL LOST");
		}
	
	}

	public boolean isLost() {
		return lost;
	}
	
	
}
