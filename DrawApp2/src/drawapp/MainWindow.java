package drawapp;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainWindow 
{
	Group root;
	Group gui;
	TextArea text;


	public MainWindow(Group root)
	{
		this.root = root;
	}

	public void buildGUI()
	{
		gui = new Group();
		gui.setTranslateY(Dimensions.getHeight() - 150);
		gui.toFront();
		root.getChildren().add(gui);
		
		Rectangle rect = new Rectangle(Dimensions.getWidth(), 150);
		rect.setFill(Color.LIGHTGRAY);
		gui.getChildren().add(rect);
		
		text = new TextArea();
		//text.setStyle("-fx-background-color: lightgray;");
		text.setWrapText(true);
		text.setPrefHeight(110);
		text.setPrefWidth(Dimensions.getWidth());
		text.setEditable(false);
		
		Button button = new Button("Close");
		button.setPrefHeight(20);
		System.out.println(button.getPrefHeight());
		button.setLayoutY(150 - button.getPrefHeight() - 10);
		button.toFront();
		EventHandler<ActionEvent> close = new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();		
			}
		};
		button.setOnAction(close);
		gui.getChildren().addAll(text, button);
		gui.toFront();
	}

	public void postMessage(String s) {
		text.setText(s);
		
	}
}