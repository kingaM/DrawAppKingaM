package drawapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ParseTurtle extends Parser {

	private ArrayList<String> ccode = new ArrayList<String>();
	private Turtle turtle;

	public ParseTurtle(ArrayList<String> ccode, Turtle turtle) throws ParseException {
		this.ccode = ccode;
		this.turtle = turtle;
		draw();
	}

	public void draw() throws ParseException {
		for (String s : ccode) {
				parseLine(s);
		}
	}

	private void parseLine(String line) throws ParseException {
		System.out.println(line);
		if (line.length() < 2)
			return;
		String command = line.split(" ")[0];
		if (command.equals("PU")) {
			penUp();
			return;
		}
		if (command.equals("PD")) {
			penDown();
			return;
		}
		if (command.equals("PC")) {
			setPenColor(line.split(" ")[1]);
			return;
		}
		if (command.equals("GF")) {
			goForward(line.substring(2, line.length()));
			return;
		}
		if (command.equals("TL")) {
			turnLeft(line.substring(2, line.length()));
			return;
		}
		if (command.equals("TR")) {
			turnRight(line.substring(2, line.length()));
			return;
		}

		throw new ParseException("Unknown drawing command: " + line);
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

	private void setPenColor(String line) throws ParseException {
		turtle.setPenColor(getColour(line));
	}

	private void penUp() {
		turtle.penUp();
	}

	private void penDown() {
		turtle.penDown();
	}

}
