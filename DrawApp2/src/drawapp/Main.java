package drawapp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.SwingUtilities;
import java.awt.Color;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class Main extends Application
{
	Group root;
	
	public static void main(String[] args)
	{
		launch(args);
		/*final MainWindow main = new MainWindow();

		SwingUtilities.invokeLater(
				new Runnable()
				{
					public void run()
					{
						ImagePanel imagePanel = main.getImagePanel();
						Reader reader = new InputStreamReader(System.in);
						Parser parser = new Parser(reader,imagePanel,main);
						parser.parse();
						imagePanel.repaint();
					}
				}
				);*/

	}
	
	private void init(Stage primaryStage) {
		root = new Group();
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, 500, 500));
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		ImagePanel image = new ImagePanel(300, 300, root);
		Reader reader = new InputStreamReader(System.in);
		Parser parser = new Parser(reader,image,null);
		MainWindow main = new MainWindow(root);
		
		parser.parse();
		main.buildGUI();
		primaryStage.show();

	}
}
