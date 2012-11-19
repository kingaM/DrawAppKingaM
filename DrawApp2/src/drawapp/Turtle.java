package drawapp;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Turtle {
	private double x, y;
	private double angle;
	private Graphics graphics;
	private Color color = Color.BLACK;
	private boolean penDown = true;

	public Turtle(double x0, double y0, double a0) {
		this.graphics = new Graphics();
		x = x0;
		y = y0;
		angle = a0;
	}
	
	public Graphics getGraphics()
	{
		return graphics;
	}

	public void turnLeft(double delta) {
		angle += delta;
	}

	public void turnRight(double delta) {
		angle -= delta;
	}

	public void goForward(double step) {
		double oldx = x;
		double oldy = y;
		x += step * Math.cos(Math.toRadians(angle));
		y += step * Math.sin(Math.toRadians(angle));
		graphics.drawLine(oldx, oldy, x, y);
	}

	public void setPenColor(Color color) {
		this.color = color;
	}

	public void penUp() {
		graphics.setColor(Color.TRANSPARENT);
	}

	public void penDown() {
		graphics.setColor(color);
	}
}