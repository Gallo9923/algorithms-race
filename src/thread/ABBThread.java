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
	//private boolean started = false;

	private boolean lost = false;

	public ABBThread(Race race, RaceControllerGUI controller, String algorithmType, String algorithmMode, int n) {
		this.race = race;
		this.controller = controller;
		this.algorithmType = algorithmType;
		this.algorithmMode = algorithmMode;
		this.n = n;
	}

	public void run() {

		Platform.runLater(new Thread() {
			@Override
			public void run() {
				controller.initializeGUI();
			}
		});
		
		ALThread al = new ALThread(race, controller, algorithmType, algorithmMode, n, this);
		
		try {
		
			if (algorithmType.equalsIgnoreCase("ADD")) {
	
				al.start();
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.addIterativeABB(n);
				} else {
					race.addRecursiveABB(n);
				}
	
			} else if (algorithmType.equalsIgnoreCase("SEARCH")) {
	
				initializeRace();
				al.start();
				
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.queryIterativeABB(n);
				} else {
					race.queryRecursiveABB(n);
				}
	
			} else {
	
				initializeRace();
				al.start();
	
				if (algorithmMode.equalsIgnoreCase("ITERATIVE")) {
					race.deleteIterativeABB(n);
				} else {
					race.deleteRecursiveABB(n);
				}
	
			}
		}catch(StackOverflowError e) {
			lost = true;
			System.out.println("ABB LOST");
		}
	}

	public void initializeRace() {

		Thread abbInit = new Thread() {
			public void run() {
				race.addIterativeABB(n);
				race.setBinaryTreeN(0);
			}
		};

		Thread alInit = new Thread() {

			public void run() {
				race.addIterativeAL(n);
				race.setArrayListN(0);
			}

		};

		Thread llInit = new Thread() {
			public void run() {

				race.addIterativeLE(n);
				race.setLinkedListN(0);
			}
		};

		abbInit.start();
		alInit.start();
		llInit.start();

		try {
			abbInit.join();
			alInit.join();
			llInit.join();
			
			//controller.blockButtons();
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public boolean isLost() {
		return lost;
	}
	
	

}
