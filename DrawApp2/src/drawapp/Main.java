package drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	Group root;
	int height, width;

	public static void main(String[] args) {
		launch(args);
	}

	private void init(Stage primaryStage) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		InitParser parser = new InitParser(reader);
		MainWindow root = new MainWindow();
		root.setMinSize(605, 505);
		root.buildGUI();
		try {
			root.addCanvas(parser.draw());
		} catch (ParseException e) {
			root.postMessage(e.getMessage());
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Draw App");
		primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
	}
}
