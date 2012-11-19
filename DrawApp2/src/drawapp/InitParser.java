package drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InitParser {
	private BufferedReader reader;
	private ArrayList<String> ccode = new ArrayList<String>();

	public InitParser(BufferedReader reader) {
		this.reader = reader;
	}

	public Parser draw() throws ParseException {
		//
		// String[] lines = {"DR 100 100 10 10", "DR 400 400 100 100",
		// "D 100 100", "DR 800 800 10 10",
		// "GC blue green", "DR 10 10 10 10", "DR 200 250 50 50",
		// "DR 0 0 40 40"};
		//
		// for(String s : lines) ccode.add(s);
		//

		try {
			String line = reader.readLine();

			while (line != null) {
				ccode.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parser p = graphicsOrTurtle();

		return p;
	}

	protected Parser graphicsOrTurtle() throws ParseException {
		String s = ccode.get(0);
		String[] array = s.split(" ");
		if (array[0].equals("T")) {
			ccode.remove(0);
			return new ParseTurtle(ccode, new Turtle(
					Double.parseDouble(array[1]), Double.parseDouble(array[2]),
					Double.parseDouble(array[3])));
		} else if (s.equals("G")) {
			ccode.remove(0);
			return new ParseGraphics(ccode);
		} else {
			return new ParseGraphics(ccode);
		}
	}

}
