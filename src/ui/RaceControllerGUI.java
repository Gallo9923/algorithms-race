package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.Race;
import thread.ABBThread;

public class RaceControllerGUI {

	@FXML
	private TextField txtN;

	@FXML
	private Button bttStart;

	@FXML
	private Label LabelTimeKeeper;

	@FXML
	private ToggleGroup algorithm;

	@FXML
	private ToggleGroup mode;

	@FXML
	private Label ALTime;

	@FXML
	private Label LLTime;

	@FXML
	private Label ABBTime;

	@FXML
	private ProgressBar alBar;

	@FXML
	private ProgressBar llBar;

	@FXML
	private ProgressBar abbBar;

	@FXML
	private Circle circleBig;

	@FXML
	private Circle circleSmall;

	private boolean isGrowing = false;

	public static final double RADIUS_STEP = 0.1;

	private Race race;

	int n = 0;

	public RaceControllerGUI(Race race) {
		this.race = race;
	}

	@FXML
	void startRace(ActionEvent event) {

		RadioButton item;
		n = 0;

		try {
			n = Integer.parseInt(txtN.getText());

			item = (RadioButton) algorithm.getSelectedToggle();
			String algorithmType = (item != null ? item.getText() : null);

			item = (RadioButton) mode.getSelectedToggle();
			String algorithmMode = (item != null ? item.getText() : null);

			if (n <= 0 || algorithmMode == null || algorithmType == null) {
				missingFieldsAlert();

			} else {

				bttStart.setDisable(true);
				txtN.setDisable(true);
				
				for (Toggle t : mode.getToggles()) {  
		            if (t instanceof RadioButton) {  
		                ((RadioButton) t).setDisable(true);  
		            }  
				}
				
				for (Toggle t : algorithm.getToggles()) {  
		            if (t instanceof RadioButton) {  
		                ((RadioButton) t).setDisable(true);  
		            }  
				}

				ABBThread abbThread = new ABBThread(race, this, algorithmType, algorithmMode, n);
				abbThread.setDaemon(true);
				abbThread.start();

			}

		} catch (NumberFormatException e) {
			numberFormatExceptionAlert();
		}

	}

	public void reEnable() {
		bttStart.setDisable(false);
		txtN.setDisable(false);
		
		for (Toggle t : mode.getToggles()) {  
            if (t instanceof RadioButton) {  
                ((RadioButton) t).setDisable(false);  
            }  
		}
		
		for (Toggle t : algorithm.getToggles()) {  
            if (t instanceof RadioButton) {  
                ((RadioButton) t).setDisable(false);  
            }  
		}
		
	}

	public void numberFormatExceptionAlert() {
		ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
		Alert alert = new Alert(AlertType.INFORMATION, "Please digit a valid number", ok);
		alert.setTitle("Warning");
		alert.setHeaderText("Warning");

		alert.showAndWait();
	}

	public void missingFieldsAlert() {
		ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
		Alert alert = new Alert(AlertType.INFORMATION, "Please fill all fields and an N bigger than 0", ok);
		alert.setTitle("Warning");
		alert.setHeaderText("Warning");

		alert.showAndWait();
	}

	public void updateTimeKeeper(long duration) {
		LabelTimeKeeper.setText(timeFormatter(duration));
	}

	public void updateABB(long duration, int progress, boolean lost) {

		if (lost == false) {
			ABBTime.setText(timeFormatter(duration));
			abbBar.setProgress((double) progress / n);
		} else {
			ABBTime.setText("LOST");
		}

	}

	public void updateAL(long duration, int progress, boolean lost) {

		if (lost == false) {
			ALTime.setText(timeFormatter(duration));
			alBar.setProgress((double) progress / n);
		} else {
			ALTime.setText("LOST");
		}

	}

	public void updateLE(long duration, int progress, boolean lost) {

		if (lost == false) {
			LLTime.setText(timeFormatter(duration));
			llBar.setProgress((double) progress / n);
		} else {
			LLTime.setText("LOST");
		}

	}

	public String timeFormatter(long duration) {

		long milliseconds = duration % 1000;
		long seconds = (duration / 1000) % 60;
		long minutes = (duration / 60000) % 60;
		String sMil = milliseconds < 10 ? ("00" + milliseconds)
				: milliseconds < 100 ? ("0" + milliseconds) : ("" + milliseconds);
		String sSec = seconds < 10 ? ("0" + seconds) : ("" + seconds);
		String sMin = minutes < 10 ? ("0" + minutes) : ("" + minutes);

		return sMin + ":" + sSec + ":" + sMil;
	}

	public void updateCircles() {
		
		if (circleBig.getRadius() <= 25) {
			isGrowing = true;
		} else if (circleBig.getRadius() >= 50) {
			isGrowing = false;
		}
		
		if(circleBig.getRadius() > circleSmall.getRadius()) {
			circleSmall.toFront();
		}else {
			circleBig.toFront();
		}

		if (isGrowing == false) {

			circleBig.setRadius(circleBig.getRadius() - RADIUS_STEP);
			circleSmall.setRadius(circleSmall.getRadius() + RADIUS_STEP);

		} else {
			
			circleBig.setRadius(circleBig.getRadius() + RADIUS_STEP);
			circleSmall.setRadius(circleSmall.getRadius() - RADIUS_STEP);
	
		}

	}
	
	public void initializeGUI() {
		
		//Circle animation
		circleBig.setRadius(50);
		circleSmall.setRadius(25);
		
		//Chronometers
		LLTime.setText("00:00:000");
		ABBTime.setText("00:00:000");
		ALTime.setText("00:00:000");
		LabelTimeKeeper.setText("00:00:000");
		
		//ProgressBars
		llBar.setProgress(0);
		abbBar.setProgress(0);
		alBar.setProgress(0);
		
	}
	

}
