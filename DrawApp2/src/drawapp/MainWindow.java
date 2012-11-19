package drawapp;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainWindow extends BorderPane {
	private TextArea text;
	private Parser graphics;

	public HBox addHBox() {
		HBox hbox = new HBox();
		hbox.setSpacing(10);
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
				try {
					postMessage(graphics.drawNextNode());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		buttonN.setOnAction(next);

//		Button buttonP = new Button("Prev Step");
//		buttonP.setPrefSize(100, 20);
//		EventHandler<ActionEvent> previous = new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				postMessage(graphics.drawPreviousNode());
//			}
//		};
//		buttonP.setOnAction(previous);

		Button buttonW = new Button("Draw All");
		buttonW.setPrefSize(100, 20);
		EventHandler<ActionEvent> all = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					postMessage(graphics.drawWhole());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		buttonW.setOnAction(all);

		Button buttonS = new Button("Save image");
		buttonS.setPrefSize(100, 20);
		EventHandler<ActionEvent> save = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					saveImage();
				} catch (IOException e) {
					postMessage(e.getMessage());
					e.printStackTrace();
				}
			}
		};
		buttonS.setOnAction(save);

		hbox.toFront();
		hbox.getChildren().addAll(button, buttonN, buttonW, buttonS);
		return hbox;
	}
	
	public void saveImage() throws IOException
	{
		Calendar cal = Calendar.getInstance();
		ImageIO.write(
				SwingFXUtils.fromFXImage(snapshot(null, null), null),
				"png", new File(cal.getTimeInMillis() + ".png"));
	}

	public void buildGUI() {
		VBox vbox = new VBox();

		text = new TextArea();
		text.setWrapText(true);
		text.setPrefHeight(110);
		text.setEditable(false);
		
		HBox hbox = addHBox();
		
		vbox.getChildren().addAll(text, hbox);
		vbox.setStyle("-fx-background-color: lightblue;");
		this.setBottom(vbox);	
	}
	
	public void addCanvas(Parser graphics)
	{
		this.graphics = graphics;
		ScrollPane scroll = new ScrollPane();

		//scroll.setMaxSize(700, 400);
		//graphics.getGraphics().setMinSize(600, 300);
		scroll.setContent(graphics.getGraphics());
		this.setCenter(scroll);
	}

	public void postMessage(String s) {
		text.setText(s);
	}
}