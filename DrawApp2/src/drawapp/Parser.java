package drawapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public abstract class Parser {

	private ArrayList<String> commands;
	protected Graphics graphics = new Graphics();
	private int i = -1;

	public Parser(ArrayList<String> commands) {
		this.commands = commands;
	}

	protected int getInteger(StringTokenizer tokenizer) throws ParseException {
		if (tokenizer.hasMoreTokens())
			return Integer.parseInt(tokenizer.nextToken());
		else
			throw new ParseException("Missing Integer value");
	}
	
	protected void setDimensions(int width, int height)
	{
		graphics.setDimensions(width, height);
	}

	protected Color getColor(String colorName) throws ParseException {
		if (colorName.equals("black")) {
			return Color.BLACK;
		}
		if (colorName.equals("blue")) {
			return Color.BLUE;
		}
		if (colorName.equals("cyan")) {
			return Color.CYAN;
		}
		if (colorName.equals("darkgray")) {
			return Color.DARKGRAY;
		}
		if (colorName.equals("gray")) {
			return Color.GRAY;
		}
		if (colorName.equals("green")) {
			return Color.GREEN;
		}
		if (colorName.equals("lightgray")) {
			return Color.LIGHTGRAY;
		}
		if (colorName.equals("magenta")) {
			return Color.MAGENTA;
		}
		if (colorName.equals("orange")) {
			return Color.ORANGE;
		}
		if (colorName.equals("pink")) {
			return Color.PINK;
		}
		if (colorName.equals("red")) {
			return Color.RED;
		}
		if (colorName.equals("white")) {
			return Color.WHITE;
		}
		if (colorName.equals("yellow")) {
			return Color.YELLOW;
		}
		if (colorName.equals("transparent")) {
			return Color.TRANSPARENT;
		}
		throw new ParseException("Invalid color name: " + colorName);
	}

	protected Double[] getDoubleArray(StringTokenizer tokenizer)
			throws ParseException {
		ArrayList<Double> arrayList = new ArrayList<Double>();
		if (tokenizer.countTokens() < 2) {
			throw new ParseException("Too little values in the array");
		}
		while (tokenizer.hasMoreTokens()) {
			double d = Double.parseDouble(tokenizer.nextToken());
			arrayList.add(d);
		}
		Double[] array = new Double[arrayList.size()];
		arrayList.toArray(array);
		return array;
	}

	protected abstract void parseLine(String line) throws ParseException;
	
	public Graphics getGraphics()
	{
		return graphics;
	}
	
	public void saveImage() throws IOException
	{
		graphics.saveImage();
	}

	public String drawWhole() throws ParseException {
		while (i < commands.size() - 1) {
			i++;
			parseLine(commands.get(i));
			// getChildren().add(nodes.get(i));
		}
		return "Drawing completed";
	}

	public String drawNextNode() throws ParseException {
		String s = "Drawing completed";
		System.out.println("In the method: ");
		if (i < commands.size() - 1) {
			i++;
			s = commands.get(i);
			parseLine(s);
			System.out.println("Drawing next node done");
			// getChildren().add(nodes.get(i));
		}
		return s;
	}
}
