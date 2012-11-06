package drawapp;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Graphics {
	
	Color color = Color.BLACK;
	Group root;
	
	public Graphics(Group root)
	{
		this.root = root;
	}

	public void setColor(Color colour) {
		this.color = colour;	
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		Line line = new Line(x1, y1, x2, y2);
		line.setFill(color);
		root.getChildren().add(line);
		
	}

	public void drawRect(int x1, int y1, int x2, int y2) {
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(Color.TRANSPARENT);
		root.getChildren().add(rectangle);
		
	}

	public void fillRect(int x1, int y1, int x2, int y2) {
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(color);
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
		arc.setFill(Color.TRANSPARENT);
		root.getChildren().add(arc);
		
	}

	public void drawOval(int x, int y, int width, int height) {
		Ellipse ellipse = new Ellipse(x+width/2, y+height/2, width/2, height/2);
		ellipse.setStroke(color);
		ellipse.setFill(Color.TRANSPARENT);
		root.getChildren().add(ellipse);
		
	}

}
