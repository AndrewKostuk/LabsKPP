package by.bsuir.lift_and_people.run;

import javafx.application.Application;
import javafx.stage.Stage;

public class GenetalThread extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	private static final String TITLE = "LiftAndPeople";

	private PaneCreatorPeople newPaneRun;

	public GenetalThread() {
		newPaneRun = new PaneCreatorPeople();
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(TITLE);
		primaryStage.setResizable(true);

		newPaneRun.createDefault();
		newPaneRun.addComponents();
		newPaneRun.setActionsToButtons();

		primaryStage.setScene(newPaneRun.getScene());
		primaryStage.show();

	}
}
