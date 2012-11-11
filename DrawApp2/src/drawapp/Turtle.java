package drawapp;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Turtle {
	private double x, y;     // turtle is at (x, y)
	private double angle;    // facing this many degrees counterclockwise from the x-axis
	private Graphics graphics;
	private Color color = Color.BLACK;

	// start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
	public Turtle(Group root, Graphics image) {
		graphics = image;
	}
	
	public void setInitialPosition(double x0, double y0, double a0) {
		x = x0;
		y = y0;
		angle = a0;
	}

	// rotate orientation delta degrees counterclockwise
	public void turnLeft(double delta) {
		angle += delta;
	}
	
	public void turnRight(double delta) {
		angle -= delta;
	}

	// move forward the given amount, with the pen down
	public void goForward(double step) {
		System.out.println("Going forward by " + step);
		double oldx = x;
		double oldy = y;
		x += step * Math.cos(Math.toRadians(angle));
		y += step * Math.sin(Math.toRadians(angle));
		graphics.drawLine(oldx, oldy, x, y);
	}

	public void setPenColor(Color color) {
		this.color = color;
		graphics.setColor(color);
	}

	public void penUp()
	{
		graphics.setColor(Color.TRANSPARENT);
	}

	public void penDown()
	{
		graphics.setColor(color);
	}
}