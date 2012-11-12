package drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IntialParser extends Parser
{
	private BufferedReader reader;
	private Graphics image;
	private MainWindow frame;
	private ArrayList<String> ccode = new ArrayList<String>();
	private Turtle turtle;

	public IntialParser(Reader reader, Graphics image, MainWindow frame, Turtle turtle)
	{
		this.reader = new BufferedReader(reader);
		this.image = image;
		this.frame = frame;
		this.turtle = turtle;
	}

	public void parse() throws ParseException
	{
			String[] lines = { 
		"600 600",
		"G",
		"DR 100 100 10 10",
		"SR 35",
		"GC blue green",
		"CFC",
		"DR 10 10 10 10"};

		for(String s : lines)
			ccode.add(s);

/*	try {
			String line = reader.readLine();

			while (line != null) {
				ccode.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		getDimensions();
	}

	public void getDimensions() throws ParseException
	{
		String s = ccode.get(0);
		StringTokenizer tokenizer = new StringTokenizer(s);
		Dimensions.setHeight(getInteger(tokenizer));
		Dimensions.setWidth(getInteger(tokenizer));
		ccode.remove(0);
	}

	public Parser graphicsOrTurtle() throws ParseException 
	{
		String s = ccode.get(0);
		ccode.remove(0);
		String[] array  = s.split(" ");
		if(array[0].equals("T"))
		{
			turtle.setInitialPosition(Double.parseDouble(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]));
			return new ParseTurtle(ccode, turtle);
		}
		if(s.equals("G"))
		{
			return new ParseGraphics(ccode, image);
		}	
		new ParseException("Unknown mode:" + s);
		return null;
	}
}
