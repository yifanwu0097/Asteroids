package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class MenuButtonFeature extends Button {

	private final static String FONT_PATH = "/resources/kenvector_future.ttf";
	private final static String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/resources/red_button_pressed.png');";
	private final static String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/resources/red_button.png');";

	public MenuButtonFeature(String text) {
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListeners();

	}

	private void setButtonFont() {

		setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));

	}

	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);

	}

	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() - 4);

	}

	private void initializeButtonListeners() {

		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}

			}
		});

		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}

			}
		});

		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());

			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(null);

			}
		});

	}

}