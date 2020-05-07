package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Race;

public class Main extends Application{
	
	private Race race;
	private RaceControllerGUI controller;
	
	public Main() {
		
		long firstSeed = 1; //TODO change to a random seed
		long secondSeed = 2;
		race = new Race(firstSeed, secondSeed);
		controller = new RaceControllerGUI(race);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlgorithmsRaceGUI.fxml")); 
		fxmlLoader.setController(controller);
		VBox vbox = fxmlLoader.load();
		
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Algorithms Race");
		primaryStage.show();
		
		
		
	}

}
