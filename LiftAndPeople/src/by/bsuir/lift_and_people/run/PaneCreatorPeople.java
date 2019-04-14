package by.bsuir.lift_and_people.run;

import by.bsuir.lift_and_people.human.Human;
import by.bsuir.lift_and_people.lift.Lift;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PaneCreatorPeople {
	private Lift newLift;

	private static final String BUTTON_LABEL_1 = "Создать человека";
	private static final String BUTTON_LABEL_2 = "Начать движение";
	private static final String BUTTON_LABEL_3 = "Проверить состояние";

	private GridPane gridpane;
	private BorderPane root;
	private Scene scene;

	private Button createHumanButton;
	private Button runButton;
	private Button checkStateButton;

	private Text currentFloorText;
	private Text targetFloorText;
	private Text liftFloorText;
	private Text passengersText;

	public PaneCreatorPeople() {
		newLift = new Lift();

		gridpane = new GridPane();
		root = new BorderPane();
		scene = new Scene(root, 770, 150);

		createHumanButton = new Button(BUTTON_LABEL_1);
		runButton = new Button(BUTTON_LABEL_2);
		checkStateButton = new Button(BUTTON_LABEL_3);

		currentFloorText = new Text("");
		targetFloorText = new Text("");
		liftFloorText = new Text("");
		passengersText = new Text("");
	}

	public void createDefault() {
		gridpane.setPadding(new Insets(10));
		gridpane.setHgap(100);
		gridpane.setVgap(10);
	}

	public void addComponents() {
		gridpane.add(createHumanButton, 0, 0);
		gridpane.add(checkStateButton, 1, 0);
		gridpane.add(runButton, 2, 0);
		root.setCenter(gridpane);

		gridpane.add(currentFloorText, 0, 1);
		gridpane.add(targetFloorText, 0, 2);
		gridpane.add(liftFloorText, 1, 1);
		gridpane.add(passengersText, 1, 2);
	}

	public void setActionsToButtons() {
		createHumanButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Human newHuman = new Human(newLift);
				newLift.setLock(newHuman.getLock()); // lock нужен для синхронизации
				currentFloorText.setText("current: " + newHuman.getCurrentFloor());
				targetFloorText.setText("target: " + newHuman.getTargetFloor());
				newHuman.start();
			}
		});

		checkStateButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				liftFloorText.setText("floor: " + newLift.getFloor());
				passengersText.setText("passengers: " + newLift.getPassengers().size());
			}
		});

		runButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				newLift.start();
			}
		});
	}

	public Scene getScene() {
		return scene;
	}
}