package drawapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

public class IntialParser extends Parser
{
	private BufferedReader reader;
	private ImagePanel image;
	private MainWindow frame;
	private ArrayList<String> ccode = new ArrayList<String>();
	private Turtle turtle;

	public IntialParser(Reader reader, ImagePanel image, MainWindow frame, Turtle turtle)
	{
		this.reader = new BufferedReader(reader);
		this.image = image;
		this.frame = frame;
		this.turtle = turtle;
	}

	public void parse() throws ParseException
	{
	//	try
	//	{
			/*String line = reader.readLine();
			ccode.add(line);

			while (line != null)
			{
				//parseLine(line);
				line = reader.readLine();
				ccode.add(line);
			}*/


				String[] lines = {
				/*		"600 600",
						"G",
					"GC white yellow",
					"DO 30 30 100 150",
					"DO 0 0 499 299",
					"DA 100 100 90 120 0 180",
					"CFC",
					"DP 0.0 0.0 10.0 10.0 30.0 0.0" };*/
						
						"600 600",
						"T",
						"PD",
						"GF 10",
						"TL 30",
						"GF 20",
						"TR 40",
						"GF 20" };
				
				for(String s : lines)
					ccode.add(s);
				getDimensions();
				graphicsOrTurtle();
			//};

			//	for(final String s : lines) {
			//		parseLine(s);
			//	}
		//}
	/*	catch (ParseException e)
		{
			frame.postMessage("Parse Exception: " + e.getMessage());
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//frame.postMessage("Drawing completed");*/
	}
	
	public void getDimensions() throws ParseException
	{
		String s = ccode.get(0);
		StringTokenizer tokenizer = new StringTokenizer(s);
		Dimensions.setHeight(getInteger(tokenizer));
		Dimensions.setWidth(getInteger(tokenizer));
		ccode.remove(0);
	}
	
	public void graphicsOrTurtle() 
	{
		String s = ccode.get(0);
		if(s.equals("T"))
		{
			turtle.setInitialPosition(100, 100, 0);
			new ParseTurtle(ccode, turtle);
		}
		if(s.equals("G"))
		{
			 new ParseGraphics(ccode, image);
		}
	}
	
	

}
