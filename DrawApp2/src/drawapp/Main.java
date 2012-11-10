package drawapp;

import java.io.InputStreamReader;
import java.io.Reader;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, Dimensions.getWidth(), Dimensions.getHeight()));
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		Graphics image = new Graphics(root);
		Reader reader = new InputStreamReader(System.in);
		
		MainWindow main = new MainWindow(root);
		Turtle turtle = new Turtle(root);
		IntialParser parser = new IntialParser(reader,image,main, turtle);
		parser.parse();
		
		init(primaryStage);
		primaryStage.setTitle("Draw App");

		main.buildGUI();
		primaryStage.show();
	}
}
