package drawapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

public class ParseGraphics extends Parser {

	public ParseGraphics(ArrayList<String> ccode)
			throws ParseException {
		super(ccode);
	}

//
//	public Graphics draw() throws ParseException {
//		for (String s : ccode) {
//			parseLine(s);
//		}
//		return image;
//	}

	protected void parseLine(String line) throws ParseException {
		String command = line.split(" ")[0];
		if (command.equals("DL")) {
			drawLine(line.substring(2, line.length()));
			return;
		}
		if (command.equals("DR")) {
			drawRect(line.substring(2, line.length()));
			return;
		}
		if (command.equals("FR")) {
			fillRect(line.substring(2, line.length()));
			return;
		}
		if (command.equals("SC")) {
			setColor(line.substring(3, line.length()));
			return;
		}
		if (command.equals("DS")) {
			drawString(line.substring(3, line.length()));
			return;
		}
		if (command.equals("DA")) {
			drawArc(line.substring(2, line.length()));
			return;
		}
		if (command.equals("DO")) {
			drawOval(line.substring(2, line.length()));
			return;
		}
		if (command.equals("DI")) {
			drawImage(line.substring(2, line.length()));
			return;
		}
		if (command.equals("DP")) {
			drawPolygon(line.substring(2, line.length()));
			return;
		}
		if (command.equals("SR")) {
			setRotate(Integer.parseInt(line.split(" ")[1]));
			return;
		}
		if (command.equals("GC")) {
			setGradientColor(line.substring(3, line.length()));
			return;
		}
		if (command.equals("SF")) {
			setFillColor(line.split(" ")[1]);
			return;
		}
		if (command.equals("CFC")) {
			clearFillColor();
			return;
		}
		if (command.equals("CSC")) {
			clearClour();
			return;
		}
		throw new ParseException("Unknown drawing command: " + line);
	}

	private void setFillColor(String color) throws ParseException {
		Color c = getColor(color);
		graphics.setFillColor(c);
	}

	private void setRotate(int angle) {
		graphics.setRotate(angle);
	}

	private void drawLine(String args) throws ParseException {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);
		graphics.drawLine(x1, y1, x2, y2);
	}

	private void drawRect(String args) throws ParseException {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);
		graphics.drawRect(x1, y1, x2, y2);
	}

	private void fillRect(String args) throws ParseException {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);
		graphics.fillRect(x1, y1, x2, y2);
	}

	private void drawArc(String args) throws ParseException {
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		int startAngle = 0;
		int arcAngle = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x = getInteger(tokenizer);
		y = getInteger(tokenizer);
		width = getInteger(tokenizer);
		height = getInteger(tokenizer);
		startAngle = getInteger(tokenizer);
		arcAngle = getInteger(tokenizer);
		graphics.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	private void drawOval(String args) throws ParseException {
		int x1 = 0;
		int y1 = 0;
		int width = 0;
		int height = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		width = getInteger(tokenizer);
		height = getInteger(tokenizer);
		graphics.drawOval(x1, y1, width, height);
	}

	private void drawString(String args) throws ParseException {
		int x = 0;
		int y = 0;
		String s = "";
		StringTokenizer tokenizer = new StringTokenizer(args);
		x = getInteger(tokenizer);
		y = getInteger(tokenizer);
		int position = args.indexOf("@");
		if (position == -1)
			throw new ParseException("DrawString string is missing");
		s = args.substring(position + 1, args.length());
		graphics.drawString(s, x, y);
	}

	private void setColor(String colorName) throws ParseException {
		graphics.setColor(getColor(colorName));
	}

	private void setGradientColor(String args) throws ParseException {
		StringTokenizer tokenizer = new StringTokenizer(args);
		String s = tokenizer.nextToken();
		Color start = getColor(s);
		Color end = getColor(tokenizer.nextToken());
		graphics.setGradientColor(start, end);
	}
	private void clearFillColor() {
		graphics.setFillColor(Color.TRANSPARENT);
	}

	private void clearClour() {
		graphics.setColor(Color.BLACK);
	}

	private void drawImage(String args) throws ParseException {
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		String path = "";
		StringTokenizer tokenizer = new StringTokenizer(args);
		x = getInteger(tokenizer);
		y = getInteger(tokenizer);
		width = getInteger(tokenizer);
		height = getInteger(tokenizer);
		int position = args.indexOf("@");
		if (position == -1)
			throw new ParseException("Path is missing: " + args);
		path = args.substring(position + 1, args.length());
		graphics.drawImage(x, y, width, height, path);
	}

	private void drawPolygon(String args) throws ParseException {
		StringTokenizer tokenizer = new StringTokenizer(args);
		Double[] array = getDoubleArray(tokenizer);
		graphics.drawPolygon(array);
	}

}
