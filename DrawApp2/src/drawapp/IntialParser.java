package drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IntialParser {
	private BufferedReader reader;
	private Graphics image;
	private MainWindow frame;
	private ArrayList<String> ccode = new ArrayList<String>();
	private Turtle turtle;

	public IntialParser(BufferedReader reader) {
		this.reader = reader;
	}

	// public Graphics draw() throws ParseException {
	//
	// String[] lines = { "D 600 600", "G", "DR 100 100 10 10", "SR 35",
	// "GC blue green", "DR 10 10 10 10", "DR 200 250 50 50", "DR 0 0 40 40"};
	//
	// for(String s : lines) ccode.add(s);
	//
	//
	// /* try {
	// String line = reader.readLine();
	//
	// while (line != null) {
	// ccode.add(line);
	// line = reader.readLine();
	// }
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }*/
	// getDimensions();
	// Parser p = graphicsOrTurtle();
	//
	// return p.draw();
	// }

	public void getDimensions() throws ParseException {
		int height, width;
		String s = ccode.get(0);
		if (s.split(" ")[0].equals("D")) {
			StringTokenizer tokenizer = new StringTokenizer(s.substring(2,
					s.length()));
			height = 0;
			width = 0;
//			height = getInteger(tokenizer);
//			width = getInteger(tokenizer);
			if (height < 300)
				throw new ParseException("Height of the window is too small");
			if (width < 500)
				throw new ParseException("Width of the window is too small");
			Dimensions.setHeight(height);
			Dimensions.setWidth(width);
			ccode.remove(0);
		} else
			throw new ParseException("Dimensions are not set");
	}

	protected Parser graphicsOrTurtle() throws ParseException {
		String s = ccode.get(0);
		String[] array = s.split(" ");
		if (array[0].equals("T")) {
			ccode.remove(0);
			turtle.setInitialPosition(Double.parseDouble(array[1]),
					Double.parseDouble(array[2]), Double.parseDouble(array[3]));
			return new ParseTurtle(ccode, turtle);
		}
		if (s.equals("G")) {
			ccode.remove(0);
			return new ParseGraphics(ccode, image);
		}
		throw new ParseException("Unknown mode:" + s);
	}

}
