package by.bsuir.bookshop.run;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	private static final String WRITER_TITLE = "Writer";
	private static final String READER_TITLE = "Reader";
	private static final String CRITIC_TIILE = "Critic";

	private PaneCreatorWriter newPaneWriter;
	private PaneCreatorReader newPaneReader;
	private PaneCreatorCritic newPaneCritic;

	public Main() {
		newPaneWriter = new PaneCreatorWriter();
		newPaneReader = new PaneCreatorReader();
		newPaneCritic = new PaneCreatorCritic();
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(WRITER_TITLE);
		primaryStage.setResizable(true);

		Stage readerStage = new Stage();
		readerStage.setTitle(READER_TITLE);
		readerStage.setResizable(true);

		Stage criticStage = new Stage();
		criticStage.setTitle(CRITIC_TIILE);
		criticStage.setResizable(true);

		newPaneWriter.setCritic(newPaneCritic.getCritic());
		newPaneReader.setWriter(newPaneWriter.getWriter());
		newPaneCritic.setWriter(newPaneWriter.getWriter());

		newPaneWriter.createDefault();
		newPaneWriter.addComponents();
		newPaneWriter.setActionsToButtons();

		newPaneReader.createDefault();
		newPaneReader.addComponents();
		newPaneReader.setActionsToButtons();

		newPaneCritic.createDefault();
		newPaneCritic.addComponents();
		newPaneCritic.setActionsToButtons();

		primaryStage.setScene(newPaneWriter.getScene());
		primaryStage.show();

		readerStage.setScene(newPaneReader.getScene());
		readerStage.show();

		criticStage.setScene(newPaneCritic.getScene());
		criticStage.show();
	}
}