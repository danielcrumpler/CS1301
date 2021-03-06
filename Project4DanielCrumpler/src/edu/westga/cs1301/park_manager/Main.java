package edu.westga.cs1301.park_manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the program.
 * 
 * @author CS1301
 * @version Spring 2019
 */
public class Main extends Application {
	public static final String WINDOW_TITLE = "The Zoo Park Manager";
	public static final String MAIN_WINDOW_VIEW = "view/MainView.fxml";

	/**
	 * JavaFX entry point.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param primaryStage the main window hook
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Main.MAIN_WINDOW_VIEW));
		loader.load();
		Scene scene = new Scene(loader.getRoot());
		primaryStage.setTitle(Main.WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Java entry point
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Main.launch(args);
	}

}
