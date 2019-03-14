package by.bsuir.random_numbers;

import javafx.application.Application;
import javafx.stage.Stage;

public class RundomNumber extends Application {

	private PaneCreator newPane;
	
	public RundomNumber() {
		newPane=new PaneCreator();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("toGuessRandom");
		primaryStage.setResizable(true);

		newPane.createDefault();
		newPane.addComponents();
		newPane.setActionsToButtons();

		primaryStage.setScene(newPane.getScene());
		primaryStage.show();
	}
}
