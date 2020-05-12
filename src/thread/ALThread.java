package thread;

import model.Race;
import ui.RaceControllerGUI;

public class ALThread extends Thread {

	private Race race;
	private RaceControllerGUI controller;
	private String algorithmType;
	private String algorithmMode;
	private int n;
	
	private boolean lost = false;

	private ABBThread abbThread;
	
	public ALThread(Race race, RaceControllerGUI controller, String algorithmType, String algorithmMode, int n, ABBThread abbThread) {
		this.race = race;
		this.controller = controller;
		this.algorithmType = algorithmType;
		this.algorithmMode = algorithmMode;
		this.n = n;
		
		this.abbThread = abbThread;
	}
	
	public void run() {
		
		LLThread llThread = new LLThread(race, controller, algorithmType, algorithmMode, n, abbThread, this);
		llThread.start();
		
		try { 
		
			if (algorithmType.equalsIgnoreCase("ADD")) {
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.addIterativeAL(n);
				} else {
					race.addRecursiveAL(n);
				}
	
			} else if (algorithmType.equalsIgnoreCase("SEARCH")) {
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.queryIterativeAL(n);
				} else {
					race.queryRecursiveAL(n);
				}
	
			} else {
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.deleteIterativeAL(n);
				} else {
					race.deleteRecursiveAL(n);
				}
	
			}
		}catch(StackOverflowError e) {
			lost = true;
			System.out.println("AL LOST");
		}
	}

	public boolean isLost() {
		return lost;
	}
	
	
	
}
