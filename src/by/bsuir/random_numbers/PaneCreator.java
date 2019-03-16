package by.bsuir.random_numbers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import java.util.Random;

public class PaneCreator {
	private static final String BUTTON_LABEL_1 = "Угадать";
	private static final String BUTTON_LABEL_2 = "Новое";
	private static final String HELP_LABEL_1 = "Ваше число меньше загаданного";
	private static final String HELP_LABEL_2 = "Ваше число больше загаданного";
	private static final String HELP_LABEL_3 = "Вы абсолютно правы";
	private static final int BOUND_FOR_RANDOM_NUMBER = 101;

	private Random random;
	private int randomNumber;

	private GridPane gridpane;
	private BorderPane root;
	private Scene scene;

	private Button guessButton;
	private Button newRandomButton;
	private Label helpLabel;
	private TextField customerChooseTextField;

	public PaneCreator() {
		random = new Random();
		randomNumber = random.nextInt(BOUND_FOR_RANDOM_NUMBER);

		gridpane = new GridPane();
		root = new BorderPane();
		scene = new Scene(root, 330, 150);

		guessButton = new Button(BUTTON_LABEL_1);
		newRandomButton = new Button(BUTTON_LABEL_2);
		helpLabel = new Label("");
		customerChooseTextField = new TextField();
	}

	public Scene getScene() {
		return scene;
	}

	public void createDefault() {
		gridpane.setPadding(new Insets(10)); // расстояние от краев окна до кнопок и текст.полей = 10
		gridpane.setHgap(100);
		gridpane.setVgap(10);

		for (int i = 0; i < 1; i++) { // создать 2 колонки
			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(100 / 2.0); // чтобы занимала каждая 50% окна
			gridpane.getColumnConstraints().add(column); // и добавить на нашу сетку окна
		}
	}

	public void addComponents() {
		gridpane.add(customerChooseTextField, 0, 0);
		gridpane.add(helpLabel, 0, 1, 2, 1);
		gridpane.add(guessButton, 0, 2);
		gridpane.add(newRandomButton, 1, 2);
		root.setCenter(gridpane);
	}

	public void setActionsToButtons() {
		newRandomButton.setOnAction(new EventHandler<ActionEvent>() { // как должна реагировать
			public void handle(ActionEvent e) { // кнопка на нажатие
				randomNumber = random.nextInt(BOUND_FOR_RANDOM_NUMBER);
			}
		});

		guessButton.setOnAction(new EventHandler<ActionEvent>() { // как должна реагировать другая кнопка на нажатие
			public void handle(ActionEvent e) {
				Integer customerChoose = Integer.parseInt(customerChooseTextField.getText());
				if (customerChoose < randomNumber) {
					helpLabel.setText(HELP_LABEL_1);
				} else {
					if (customerChoose > randomNumber) {
						helpLabel.setText(HELP_LABEL_2);
					} else
						helpLabel.setText(HELP_LABEL_3);
				}
			}
		});
	}

}