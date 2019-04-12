package by.bsuir.lift_and_people.run;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PaneCreatorPeople {
	private static final String BUTTON_LABEL_1 = "Ехать вверх";
	private static final String BUTTON_LABEL_2 = "Ехать вниз";
	private static final String BUTTON_LABEL_3 = "Посадка высадка";

	private GridPane gridpane;
	private BorderPane root;
	private Scene scene;

	private Button runUpButton;
	private Button runDownButton;
	private Button enterExitButton;
	
	public PaneCreatorPeople() {
	gridpane = new GridPane();
	root = new BorderPane();
	scene = new Scene(root, 330, 150);

	runUpButton = new Button(BUTTON_LABEL_1);
	runDownButton = new Button(BUTTON_LABEL_2);
	enterExitButton = new Button(BUTTON_LABEL_3);
}

public void createDefault() {
	gridpane.setPadding(new Insets(10));
	gridpane.setHgap(100);
	gridpane.setVgap(10);
}

public void addComponents() {
	gridpane.add(runUpButton, 0, 0);
	gridpane.add(runDownButton, 0, 1);
	gridpane.add(enterExitButton, 0, 2);
	root.setCenter(gridpane);
}

public void setActionsToButtons() {
	runUpButton.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {

		}
	});

	runDownButton.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {

		}
	});

	enterExitButton.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {

		}
	});
}

public Scene getScene() {
	return scene;
}
}
