package by.bsuir.bookshop.run;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	private static final String WRITER_TITLE = "Writer";
	private static final String READER_TITLE = "Reader";

	private PaneCreatorWriter newPaneWriter;
	private PaneCreatorReader newPaneReader;

	public Main() {
		newPaneWriter = new PaneCreatorWriter();
		newPaneReader = new PaneCreatorReader();
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(WRITER_TITLE);
		primaryStage.setResizable(true);

		Stage readerStage = new Stage();
		readerStage.setTitle(READER_TITLE);
		readerStage.setResizable(true);

		newPaneWriter.createDefault();
		newPaneWriter.addComponents();
		newPaneWriter.setActionsToButtons();

		newPaneReader.setWriter(newPaneWriter.getWriter());
		newPaneReader.createDefault();
		newPaneReader.addComponents();
		newPaneReader.setActionsToButtons();

		primaryStage.setScene(newPaneWriter.getScene());
		primaryStage.show();

		readerStage.setScene(newPaneReader.getScene());
		readerStage.show();
	}
}
