package drawapp;

import javafx.scene.Group;
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
	
	Color color = Color.BLACK;
	Paint fill = Color.TRANSPARENT;
	Group root;
	
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
		Line line = new Line(oldx, oldy, x, y);
		line.setFill(color);
		root.getChildren().add(line);
		
	}

	public void drawRect(int x1, int y1, int x2, int y2) {
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(fill);
		root.getChildren().add(rectangle);
		
	}

	public void fillRect(int x1, int y1, int x2, int y2) {
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(fill);
		root.getChildren().add(rectangle);
		
	}

	public void drawString(String s, int x, int y) {
		Text text = new Text(x, y, s);
		text.setStroke(color);
		root.getChildren().add(text);
		
	}

	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		Arc arc = new Arc(x+width/2, y+height/2, width/2, height/2, startAngle, arcAngle);
		arc.setStroke(color);
		arc.setFill(fill);
		root.getChildren().add(arc);
		
	}

	public void drawOval(int x, int y, int width, int height) {
		Ellipse ellipse = new Ellipse(x+width/2, y+height/2, width/2, height/2);
		ellipse.setStroke(color);
		ellipse.setFill(fill);
		root.getChildren().add(ellipse);
		
	}

	public void drawImage(int x, int y, int width, int height, String path) {
		System.out.println(x + " " + y + " " + width + " " + height);
		ImageView image = new ImageView(new Image(path, width, height, false, false));
		image.setLayoutX(x);
		image.setLayoutY(y);
		root.getChildren().add(image);
		
	}

	public void drawPolygon(Double[] array) {
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(array);
		polygon.setStroke(color);
		polygon.setFill(fill);
		root.getChildren().add(polygon);
	}

}
