package by.bsuir.bookshop.run;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import by.bsuir.bookshop.people.*;;

public class PaneCreatorReader {
	private static final String BUTTON_LABEL_1 = "Создать читателя";
	private static final String BUTTON_LABEL_2 = "Читать книгу";
	private static final String BUTTON_LABEL_3 = "Оставить отзыв";

	private GridPane gridpane;
	private BorderPane root;
	private Scene scene;

	private Button createReaderButton;
	private Button readNewBookButton;
	private Button giveOpinionButton;

	private TextField nameReader;
	private Text readBookMessage;

	private Reader newReader;
	private Writer newWriter;

	public PaneCreatorReader() {
		gridpane = new GridPane();
		root = new BorderPane();
		scene = new Scene(root, 330, 150);

		createReaderButton = new Button(BUTTON_LABEL_1);
		readNewBookButton = new Button(BUTTON_LABEL_2);
		giveOpinionButton = new Button(BUTTON_LABEL_3);

		readBookMessage = new Text("");
		nameReader = new TextField();
		newWriter = new Writer("");
	}

	public void createDefault() {
		gridpane.setPadding(new Insets(10)); // расстояние от краев окна до кнопок и текст.полей = 10
		gridpane.setHgap(100);
		gridpane.setVgap(10);
	}

	public void addComponents() {
		gridpane.add(nameReader, 0, 0);
		gridpane.add(createReaderButton, 0, 1);
		root.setCenter(gridpane);
	}

	public void setActionsToButtons() {
		createReaderButton.setOnAction(new EventHandler<ActionEvent>() { // как должна реагировать
			public void handle(ActionEvent e) { // кнопка на нажатие
				newReader = new Reader(nameReader.getText());
				gridpane.add(readNewBookButton, 0, 2);
				gridpane.add(giveOpinionButton, 0, 3);
				gridpane.add(readBookMessage, 1, 2);
			}
		});

		readNewBookButton.setOnAction(new EventHandler<ActionEvent>() { // как должна реагировать
			public void handle(ActionEvent e) { // кнопка на нажатие
				newReader.read(newWriter);
				readBookMessage.setText("read book: " + newReader.getBook().getName());
			}
		});

		giveOpinionButton.setOnAction(new EventHandler<ActionEvent>() { // как должна реагировать
			public void handle(ActionEvent e) { // кнопка на нажатие
				newWriter.setOpinion(newReader.giveOpinion(), newReader.getBookIndex());
			}
		});
	}

	public void setWriter(Writer w) {
		newWriter = w;
	}

	public Scene getScene() {
		return scene;
	}
}