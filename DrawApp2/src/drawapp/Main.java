package drawapp;

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

public class Main extends Application
{
	Group root;
	int height, width;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	private void init(Stage primaryStage) {
		root = new Group();
		Group graphics = new Group();
		root.getChildren().add(graphics);
		
		Graphics image = new Graphics(graphics);
		Reader reader = new InputStreamReader(System.in);
		
		MainWindow main = new MainWindow(graphics, image);
		
		Turtle turtle = new Turtle(graphics, image);
		IntialParser parser = new IntialParser(reader,image,main, turtle);
		try {
			parser.parse();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			main.postMessage(e.getMessage());
			e.printStackTrace();
		}
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, Dimensions.getWidth(), Dimensions.getHeight()));
		main.buildGUI();
		
		try {
			Parser mode = parser.graphicsOrTurtle();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			main.postMessage(e.getMessage());
			e.printStackTrace();
		}
		//mode.drawNext();
		primaryStage.setTitle("Draw App");
		primaryStage.show();
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
	}
}
