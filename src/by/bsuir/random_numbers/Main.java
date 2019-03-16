package by.bsuir.random_numbers;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private static final String TITLE = "toGuessRandom";

	private PaneCreator newPane;

	public Main() {
		newPane = new PaneCreator();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(TITLE);
		primaryStage.setResizable(true);

		newPane.createDefault();
		newPane.addComponents();
		newPane.setActionsToButtons();

		primaryStage.setScene(newPane.getScene());
		primaryStage.show();
	}
}
