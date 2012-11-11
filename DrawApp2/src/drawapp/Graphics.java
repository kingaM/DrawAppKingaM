package drawapp;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Graphics {

	private Color color = Color.BLACK;
	private Paint fill = Color.TRANSPARENT;
	private Group root;
	private ArrayList<Node> nodes = new ArrayList<Node>();
	private ArrayList<String> commands = new ArrayList<String>();
	private int i = 0;

	public Graphics(Group root)
	{
		this.root = new Group();
		root.getChildren().add(this.root);
		this.root.toBack();
	}

	public void setColor(Color colour) {
		this.color = colour;	
	}

	public void setGradientColor(Color start, Color end)
	{
		Stop[] stops = new Stop[] { new Stop(0, start), new Stop(1, end)};
		LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		this.fill = lg1;
	}

	public void drawLine(double oldx, double oldy, double x, double y) {
		String s = "Draw line startX = " + oldx + " startY = " + oldy + " endX = " + x + " endY = " + y;
		Line line = new Line(oldx, oldy, x, y);
		line.setStroke(color);
		line.setFill(color);
		System.out.println(line);
		nodes.add(line);
		commands.add(s);
		//root.getChildren().add(line);

	}

	public void drawRect(int x1, int y1, int x2, int y2) {
		String s = "Draw rectangle X = " + x1 + " Y = " + y1 + " width = " + x2 + " height = " + y2;
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(fill);
		nodes.add(rectangle);
		commands.add(s);
		//	root.getChildren().add(rectangle);

	}

	public void fillRect(int x1, int y1, int x2, int y2) {
		String s = "Draw rectangle X = " + x1 + " Y = " + y1 + " width = " + x2 + " height = " + y2;
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(fill);
		nodes.add(rectangle);
		commands.add(s);
		//root.getChildren().add(rectangle);

	}

	public void drawString(String string, int x, int y) {
		String s = "Draw string X = " + x + " Y = " + y + " string = " + string;
		Text text = new Text(x, y, s);
		text.setStroke(color);
		nodes.add(text);
		commands.add(s);
		//root.getChildren().add(text);

	}

	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		String s = "Draw arc X = " + x + " Y = " + y + " width = " + width + " height = " + height;
		Arc arc = new Arc(x+width/2, y+height/2, width/2, height/2, startAngle, arcAngle);
		arc.setStroke(color);
		arc.setFill(fill);
		nodes.add(arc);
		commands.add(s);
		//root.getChildren().add(arc);

	}

	public void drawOval(int x, int y, int width, int height) {
		String s = "Draw oval X = " + x + " Y = " + y + " width = " + width + " height = " + height;
		Ellipse ellipse = new Ellipse(x+width/2, y+height/2, width/2, height/2);
		ellipse.setStroke(color);
		ellipse.setFill(fill);
		nodes.add(ellipse);
		commands.add(s);
		//root.getChildren().add(ellipse);

	}

	public void drawImage(int x, int y, int width, int height, String path) {
		String s = "Draw image X = " + x + " Y = " + y + " width = " + width + " height = " + height + " path = " + path;
		ImageView image = new ImageView(new Image(path, width, height, false, false));
		image.setLayoutX(x);
		image.setLayoutY(y);
		nodes.add(image);
		commands.add(s);
		//root.getChildren().add(image);
	}

	public void drawPolygon(Double[] array) {
		String s = "Draw polygon " + Arrays.toString(array);
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(array);
		polygon.setStroke(color);
		polygon.setFill(fill);
		nodes.add(polygon);
		commands.add(s);
		//root.getChildren().add(polygon);
	}
	
	public String drawWhole()
	{
		while(i < nodes.size()) {
			root.getChildren().add(nodes.get(i));
			i++;
		}
		return"Drawing completed";
	}

	public String drawNextNode()
	{
		String s = "Drawing completed";
		if(i < nodes.size()) {
			s = commands.get(i);
			root.getChildren().add(nodes.get(i));
			i++;
		}
		return s;
	}

	public String drawPreviousNode()
	{
		String s = "Nothing drawn yet";
		if(i > 1) {
			i--;
			root.getChildren().remove(nodes.get(i));
			s = commands.get(i-1);
		}
		if(i == 1) {
			root.getChildren().remove(nodes.get(i));
			s = commands.get(i-1);
			i--;
		}
		else if(i == 0) {
			root.getChildren().remove(nodes.get(i));
		}
		return s;
	}

}
