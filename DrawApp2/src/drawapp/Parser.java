package drawapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

public class Parser {

	protected int getInteger(StringTokenizer tokenizer) throws ParseException
	{
		if (tokenizer.hasMoreTokens())
			return Integer.parseInt(tokenizer.nextToken());
		else
			throw new ParseException("Missing Integer value");
	}
	
	protected Color getColour(String colourName) throws ParseException
	{
		if (colourName.equals("black")) { return Color.BLACK; }
		if (colourName.equals("blue")) { return Color.BLUE;}
		if (colourName.equals("cyan")) { return Color.CYAN;}
		if (colourName.equals("darkgray")) { return Color.DARKGRAY;}
		if (colourName.equals("gray")) { return Color.GRAY;}
		if (colourName.equals("green")) { return Color.GREEN;}
		if (colourName.equals("lightgray")) { return Color.LIGHTGRAY;}
		if (colourName.equals("magenta")) { return Color.MAGENTA;}
		if (colourName.equals("orange")) { return Color.ORANGE;}
		if (colourName.equals("pink")) { return Color.PINK;}
		if (colourName.equals("red")) { return Color.RED;}
		if (colourName.equals("white")) { return Color.WHITE;}
		if (colourName.equals("yellow")) { return Color.YELLOW;}
		if (colourName.equals("transparent")) { return Color.TRANSPARENT;}
		throw new ParseException("Invalid colour name");
	}
	
	protected Double[] getDoubleArray(StringTokenizer tokenizer) throws ParseException
	{
		ArrayList<Double> arrayList = new ArrayList<Double>();
		if(tokenizer.countTokens() < 2) {
			throw new ParseException("Too little values in the array");
		}
		while(tokenizer.hasMoreTokens()) {
			double d = Double.parseDouble(tokenizer.nextToken());
			arrayList.add(d );
			System.out.println(d);
		}
		Double[] array = new Double[arrayList.size()];
		arrayList.toArray(array);
		return array;
	}
}
