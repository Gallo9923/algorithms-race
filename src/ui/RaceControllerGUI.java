package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import model.Race;
import thread.ABBThread;

public class RaceControllerGUI {

	@FXML
	private TextField txtN;

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

	private Race race;
	private long t1;

	boolean ABBFinished = false;
	boolean LLFinished = false;
	boolean ALFinished = false;
	
	public RaceControllerGUI(Race race) {
		this.race = race;
	}

	@FXML
	void startRace(ActionEvent event) {

		RadioButton item;
		int n = 0;

		try {
			n = Integer.parseInt(txtN.getText());

			item = (RadioButton) algorithm.getSelectedToggle();
			String algorithmType = (item != null ? item.getText() : null);

			item = (RadioButton) mode.getSelectedToggle();
			String algorithmMode = (item != null ? item.getText() : null);

			if (n <= 0 || algorithmMode == null || algorithmType == null) {
				missingFieldsAlert();

			} else {
				
				ABBThread abbThread = new ABBThread(race, this, algorithmType, algorithmMode, n);
				abbThread.start();

			}

		} catch (NumberFormatException e) {
			numberFormatExceptionAlert();
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

	public void updateABBTime(long t2) {

		ABBTime.setText(timeFormatter(t2 - t1));

	}
	
	public void updateALTime(long t2) {
		ABBTime.setText(timeFormatter(t2 - t1));
	}

	public String timeFormatter(long millis) {

		// TODO make the formatter in HH:MM:SS

		return millis + "";
	}

}
