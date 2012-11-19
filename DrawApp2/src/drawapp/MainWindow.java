package drawapp;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainWindow extends BorderPane {
	private TextArea text;
	private Graphics graphics;

	public HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.setPrefWidth(Dimensions.getWidth());
		hbox.setAlignment(Pos.CENTER);

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
		return hbox;
	}

	public void buildGUI() {

		Rectangle rect = new Rectangle(Dimensions.getWidth(), 150);
		rect.setFill(Color.LIGHTBLUE);
		
		VBox vbox = new VBox();

		text = new TextArea();
		text.setWrapText(true);
		text.setPrefHeight(110);
		text.setPrefWidth(Dimensions.getWidth());
		text.setEditable(false);
		
		HBox hbox = addHBox();
		
		vbox.getChildren().addAll(text, hbox);
		vbox.setStyle("-fx-background-color: lightblue;");
		this.setBottom(vbox);	
	}
	
	public void addCanvas(Graphics graphics)
	{
		this.graphics = graphics;
		ScrollPane scroll = new ScrollPane();

		scroll.setMinSize(600, 300);
		scroll.setContent(graphics);
		this.setCenter(scroll);
	}

	public void postMessage(String s) {
		text.setText(s);
	}
}