package drawapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

public class Parser {

	protected int getInteger(StringTokenizer tokenizer) throws ParseException {
		if (tokenizer.hasMoreTokens())
			return Integer.parseInt(tokenizer.nextToken());
		else
			throw new ParseException("Missing Integer value");
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
			System.out.println(d);
		}
		Double[] array = new Double[arrayList.size()];
		arrayList.toArray(array);
		return array;
	}
}
