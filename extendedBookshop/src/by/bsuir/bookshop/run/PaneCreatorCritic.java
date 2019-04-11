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

import by.bsuir.bookshop.people.*;

public class PaneCreatorCritic {

	private static final String BUTTON_LABEL_1 = "Создать критика";
	private static final String BUTTON_LABEL_2 = "Оставить рецензии";

	private GridPane gridpane;
	private BorderPane root;
	private Scene scene;

	private Button createCriticButton;
	private Button giveRecencesButton;

	private TextField nameCritic;
	private Text readBookMessage;/////// ??????????????////////////

	private Critic newCritic;
	private Writer newWriter;

	public PaneCreatorCritic() {
		gridpane = new GridPane();
		root = new BorderPane();
		scene = new Scene(root, 330, 150);

		createCriticButton = new Button(BUTTON_LABEL_1);
		giveRecencesButton = new Button(BUTTON_LABEL_2);

		readBookMessage = new Text("");////// ???????????//////
		nameCritic = new TextField();
		newWriter = new Writer("");
		newCritic = new Critic("");
	}

	public void createDefault() {
		gridpane.setPadding(new Insets(10));
		gridpane.setHgap(100);
		gridpane.setVgap(10);
	}

	public void addComponents() {
		gridpane.add(nameCritic, 0, 0);
		gridpane.add(createCriticButton, 0, 1);
		root.setCenter(gridpane);
	}

	public void setActionsToButtons() {
		createCriticButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				newCritic.setName(nameCritic.getText());
				gridpane.add(giveRecencesButton, 0, 2);
				gridpane.add(readBookMessage, 1, 2); ////// **************/////////////////////////
			}
		});

		giveRecencesButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				newCritic.setWriter(newWriter);
				newCritic.writeRecense();

			}
		});
	}

	public void setWriter(Writer w) {
		newWriter = w;
	}

	public Scene getScene() {
		return scene;
	}

	public Critic getCritic() {
		return newCritic;
	}

}
