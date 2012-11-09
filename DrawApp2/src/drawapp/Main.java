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
		height = 300;
		width = 500;
		root = new Group();
		ImagePanel image = new ImagePanel(Dimensions.getHeight(), Dimensions.getWidth(), root, primaryStage);
		Reader reader = new InputStreamReader(System.in);
		
		MainWindow main = new MainWindow(root);
		Parser parser = new Parser(reader,image,main);
		parser.parse();
		parser.getDimensions();
		
		init(primaryStage);
		primaryStage.setTitle("Draw App");

		main.buildGUI();
		primaryStage.show();
		parser.draw();
	}
}
