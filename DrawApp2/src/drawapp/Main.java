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
		root = new Group();
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, width, height));
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		height = 300;
		width = 500;
		init(primaryStage);
		primaryStage.setTitle("Draw App");
		
		
		ImagePanel image = new ImagePanel(height, width, root);
		Reader reader = new InputStreamReader(System.in);
		
		MainWindow main = new MainWindow(root, width, height);
		Parser parser = new Parser(reader,image,main);
		
		main.buildGUI();
		
		parser.parse();
		primaryStage.show();
	}
}
