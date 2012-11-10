package drawapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

public class ParseTurtle {
	
	private ArrayList<String> ccode = new ArrayList<String>();
	Turtle turtle;
	
	public ParseTurtle(ArrayList<String> ccode, Turtle turtle)
	{
		this.ccode = ccode;
		this.turtle = turtle;
		draw();
	}
	
	public void draw()
	{
		for(String s : ccode)
		{
			try {
				parseLine(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	private void parseLine(String line) throws ParseException
	{
		System.out.println(line);
		if (line.length() < 2) return;
		String command = line.split(" ")[0];
		if (command.equals("PU")) { penUp(); return; }
		if (command.equals("PD")) { penDown(); return; }
		if (command.equals("PC")) { setPenColor(line.split(" ")[1]); return; }
		if (command.equals("GF")) { goForward(line.substring(2,line.length())); return;};
		if (command.equals("TL")) { turnLeft(line.substring(2,line.length())); return;};
		if (command.equals("TR")) { turnRight(line.substring(2,line.length())); return;};
		
		throw new ParseException("Unknown drawing command");
	}
	
	private void turnLeft(String substring) throws ParseException {
		int angle = 0;
		StringTokenizer tokenizer = new StringTokenizer(substring);
		angle = getInteger(tokenizer);
		turtle.turnLeft(angle);
	}
	
	private void turnRight(String substring) throws ParseException {
		int angle = 0;
		StringTokenizer tokenizer = new StringTokenizer(substring);
		angle = getInteger(tokenizer);
		turtle.turnRight(angle);
	}

	private void goForward(String substring) throws ParseException {
		int step = 0;
		StringTokenizer tokenizer = new StringTokenizer(substring);
		step = getInteger(tokenizer);
		turtle.goForward(step);
	}
	
	private int getInteger(StringTokenizer tokenizer) throws ParseException
	{
		if (tokenizer.hasMoreTokens())
			return Integer.parseInt(tokenizer.nextToken());
		else
			throw new ParseException("Missing Integer value");
	}

	private void setPenColor(String line) throws ParseException {
		turtle.setPenColor(getColour(line));
	}

	private void penUp()
	{
		turtle.penUp();
	}
	
	private void penDown()
	{
		turtle.penDown();
	}
	
	private Color getColour(String colourName) throws ParseException
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

}
