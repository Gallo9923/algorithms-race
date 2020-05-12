package thread;

import javafx.application.Platform;
import model.Race;
import ui.RaceControllerGUI;

public class UpdateThread extends Thread{

	private Race race;
	private RaceControllerGUI controller;
	private int n;
	
	private ABBThread abbThread; 
	private ALThread alThread; 
	private LLThread llThread;
	
	private long abbTime = 0;
	private long llTime =  0;
	private long alTime = 0;
	
	private int abbN = 0;
	private int llN = 0;
	private int alN = 0;
	
	boolean ABBFinished = false;
	boolean LLFinished = false;
	boolean ALFinished = false;
	
	public UpdateThread(Race race, RaceControllerGUI controller, int n, ABBThread abbThread, ALThread alThread, LLThread llThread) {
		this.race = race;
		this.controller = controller;
		this.n = n;
		
		this.abbThread = abbThread;
		this.alThread = alThread;
		this.llThread =  llThread;
		
	}

	public void run() {

		long t1 = System.currentTimeMillis();
		
		
		while(ABBFinished == false || LLFinished == false || ALFinished == false) {
			
			long t2 = System.currentTimeMillis();
			
			if(abbThread.isAlive() && ABBFinished == false) {
				abbTime = t2 - t1;
			}else if(abbThread.isAlive() == false) {
				ABBFinished = true;
			}
			
			if(llThread.isAlive() && LLFinished == false) {
				llTime = t2 - t1;
			}else if(llThread.isAlive() == false) {
				LLFinished = true;
			}
			
			if(alThread.isAlive() && ALFinished == false) {
				alTime = t2 - t1;
			}else if(alThread.isAlive() == false) {
				ALFinished = true;
			}
			
			abbN = race.getBinaryTreeN();
			llN = race.getLinkedListN();
			alN = race.getArrayListN();
			
			Platform.runLater(new Thread() {
				@Override
				public void run() {
					
					controller.updateABB(abbTime, abbN, abbThread.isLost());
					controller.updateLE(llTime, llN, llThread.isLost());
					controller.updateAL(alTime, alN, alThread.isLost());
					controller.updateCircles();
					
					long timeKeeperDuration = Math.max(abbTime, Math.max(llTime, alTime));
					controller.updateTimeKeeper(timeKeeperDuration);
					
				}
			});
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		controller.reEnable();
		
	}
	
}
