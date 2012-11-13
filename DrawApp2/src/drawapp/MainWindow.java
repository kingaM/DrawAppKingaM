package drawapp;


import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainWindow 
{
	private Group root;
	private Group gui;
	private TextArea text;
	private Graphics graphics;


	public MainWindow(Group root, Graphics graphics)
	{
		this.root = root;
		this.graphics = graphics;
	}

	public void addHBox() {
		HBox hbox = new HBox();
		hbox.setSpacing(10);

		Button button = new Button("Close Window");
		button.setPrefSize(100, 20);
		EventHandler<ActionEvent> close = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();		
			}
		};
		button.setOnAction(close);

		Button buttonN = new Button("Next Step");
		buttonN.setPrefSize(100, 20);
		EventHandler<ActionEvent> next = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				postMessage(graphics.drawNextNode());	
			}
		};
		buttonN.setOnAction(next);
		
		Button buttonP = new Button("Prev Step");
		buttonP.setPrefSize(100, 20);
		EventHandler<ActionEvent> previous = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				postMessage(graphics.drawPreviousNode());	
			}
		};
		buttonP.setOnAction(previous);
		
		Button buttonW = new Button("Draw All");
		buttonW.setPrefSize(100, 20);
		EventHandler<ActionEvent> all = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				postMessage(graphics.drawWhole());
		/*		Platform.runLater(
				graphics.slowMotion());*/
			}
		};
		buttonW.setOnAction(all);
		
		Button buttonS = new Button("Save image");
		buttonS.setPrefSize(100, 20);
		EventHandler<ActionEvent> save = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					graphics.saveImage();
				} catch (IOException e) {
					postMessage(e.getMessage());
					e.printStackTrace();
				}	
			}
		};
		buttonS.setOnAction(save);

		hbox.toFront();
		hbox.getChildren().addAll(button, buttonN, buttonP, buttonW, buttonS);
		hbox.setLayoutY(150 - button.getPrefHeight() - 10);
		gui.getChildren().add(hbox);

	}

	public void buildGUI()
	{
		gui = new Group();

		gui.setTranslateY(Dimensions.getHeight() - 150);
		gui.toFront();
		root.getChildren().add(gui);

		Rectangle rect = new Rectangle(Dimensions.getWidth(), 150);
		rect.setFill(Color.LIGHTBLUE);
		gui.getChildren().add(rect);

		text = new TextArea();
		text.setWrapText(true);
		text.setPrefHeight(110);
		text.setPrefWidth(Dimensions.getWidth());
		text.setEditable(false);

		addHBox();
		gui.getChildren().add(text);
		gui.toFront();
	}

	public void postMessage(String s) {
		text.setText(s);
	}
}