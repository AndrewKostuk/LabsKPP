package by.bsuir.bookshop.run;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

import by.bsuir.bookshop.book.*;
import by.bsuir.bookshop.people.*;

public class PaneCreatorWriter {
	private static final String BUTTON_LABEL_1 = "Создать писателя";
	private static final String BUTTON_LABEL_2 = "Написать книгу";
	private static final String BUTTON_LABEL_3 = "Показать книги";
	private static final String BUTTON_LABEL_4 = "Показать рецензии";

	private GridPane gridpane;
	private BorderPane root;
	private Scene scene;

	private Button createWriterButton;
	private Button createNewBookButton;
	private Button showAllBooksButton;
	private Button showAllRecencesButton;

	private TextField nameWriter;
	private Label bookName;

	private Writer newWriter;
	private Critic newCritic;
	private ArrayList<Book> showList;
	private ArrayList<String> opinionList;
	private ArrayList<Recense> recenseList;

	public PaneCreatorWriter() {
		gridpane = new GridPane();
		root = new BorderPane();
		scene = new Scene(root, 330, 150);

		createWriterButton = new Button(BUTTON_LABEL_1);
		createNewBookButton = new Button(BUTTON_LABEL_2);
		showAllBooksButton = new Button(BUTTON_LABEL_3);
		showAllRecencesButton = new Button(BUTTON_LABEL_4);

		nameWriter = new TextField();
		bookName = new Label("");

		newWriter = new Writer("");
		showList = new ArrayList<>();
		opinionList = new ArrayList<>();
	}

	public void createDefault() {
		gridpane.setPadding(new Insets(10));
		gridpane.setHgap(100);
		gridpane.setVgap(10);
	}

	public void addComponents() {
		gridpane.add(nameWriter, 0, 0);
		gridpane.add(createWriterButton, 0, 1);
		root.setCenter(gridpane);
	}

	public void setActionsToButtons() {
		createWriterButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				newWriter.setName(nameWriter.getText());
				gridpane.add(createNewBookButton, 0, 2);
				gridpane.add(showAllBooksButton, 0, 3);
				gridpane.add(showAllRecencesButton, 1, 3);
			}
		});

		createNewBookButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				newWriter.writeBook();
			}
		});

		showAllBooksButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				showList = newWriter.getLiteratureList();
				for (int i = 0; i < showList.size(); i++) {
					opinionList = showList.get(i).getOpinions();
					bookName.setText(showList.get(i).getName() + "   "
							+ opinionList.toString().replace("[", "").replace("]", ""));
					gridpane.add(bookName, 0, 4 + i);
					bookName = new Label("");
				}
			}
		});

		showAllRecencesButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				recenseList = newCritic.getRecenseList();
				for (int i = 0; i < recenseList.size(); i++) {
					bookName.setText(recenseList.get(i).getName() + recenseList.get(i).getRecense());
					gridpane.add(bookName, 1, 4 + i);
					bookName = new Label("");
				}
			}
		});
	}

	public Scene getScene() {
		return scene;
	}

	public Writer getWriter() {
		return newWriter;
	}

	public void setCritic(Critic c) {
		newCritic = c;
	}
}
