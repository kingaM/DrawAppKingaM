package drawapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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

import javax.imageio.ImageIO;

public class Graphics extends Pane {

	private Color color = Color.BLACK;
	private Paint fill = Color.TRANSPARENT;
	private int angle;

	public Graphics() {
		setPrefSize(600, 300);
	}
	
	public void setDimensions(int width, int height)
	{
		setPrefSize(width, height);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setRotate(int angle) {
		this.angle = angle;
	}

	public void setFillColor(Color color) {
		this.fill = color;
	}

	public void setGradientColor(Color start, Color end) {
		Stop[] stops = new Stop[] { new Stop(0, start), new Stop(1, end) };
		LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true,
				CycleMethod.NO_CYCLE, stops);
		this.fill = lg1;
	}

	public void drawLine(double oldx, double oldy, double x, double y) {
		Line line = new Line(oldx, oldy, x, y);
		line.setStroke(color);
		line.setFill(color);
		line.setRotate(angle);
		getChildren().add(line);

	}

	public void drawRect(int x1, int y1, int x2, int y2) {
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(fill);
		rectangle.setRotate(angle);
		getChildren().add(rectangle);

	}

	public void fillRect(int x1, int y1, int x2, int y2) {
		Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
		rectangle.setStroke(color);
		rectangle.setFill(fill);
		rectangle.setRotate(angle);
		getChildren().add(rectangle);

	}

	public void drawString(String string, int x, int y) {
		Text text = new Text(x, y, string);
		text.setStroke(color);
		text.setRotate(angle);
		getChildren().add(text);
	}

	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		Arc arc = new Arc(x + width / 2, y + height / 2, width / 2, height / 2,
				startAngle, arcAngle);
		arc.setStroke(color);
		arc.setFill(fill);
		arc.setRotate(angle);
		getChildren().add(arc);
	}

	public void drawOval(int x, int y, int width, int height) {
		Ellipse ellipse = new Ellipse(x + width / 2, y + height / 2, width / 2,
				height / 2);
		ellipse.setStroke(color);
		ellipse.setFill(fill);
		ellipse.setRotate(angle);
		getChildren().add(ellipse);

	}

	public void drawImage(int x, int y, int width, int height, String path) {
		ImageView image = new ImageView(new Image(path, width, height, false,
				false));
		image.setLayoutX(x);
		image.setLayoutY(y);
		image.setRotate(angle);
		getChildren().add(image);
	}

	public void drawPolygon(Double[] array) {
		String s = "Draw polygon " + Arrays.toString(array);
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(array);
		polygon.setStroke(color);
		polygon.setFill(fill);
		polygon.setRotate(angle);
		getChildren().add(polygon);
	}

	public void saveImage() throws IOException {
		Calendar cal = Calendar.getInstance();
		ImageIO.write(
				SwingFXUtils.fromFXImage(snapshot(null, null), null),
				"png", new File(cal.getTimeInMillis() + ".png"));
	}
	
	public void remove(Node node) {
		getChildren().remove(node);
	}

}
