package drawapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

public class ParseGraphics extends Parser{
	
	private ArrayList<String> ccode = new ArrayList<String>();
	Graphics image;
	
	public ParseGraphics(ArrayList<String> ccode, Graphics image)
	{
		this.ccode = ccode;
		this.image = image;
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
		if (line.length() < 2) return;
		String command = line.split(" ")[0];
		if (command.equals("DL")) { drawLine(line.substring(2,line.length())); return; }
		if (command.equals("DR")) { drawRect(line.substring(2, line.length())); return; }
		if (command.equals("FR")) { fillRect(line.substring(2, line.length())); return; }
		if (command.equals("SC")) { setColour(line.substring(3, line.length())); return; }
		if (command.equals("DS")) { drawString(line.substring(3, line.length())); return; }
		if (command.equals("DA")) { drawArc(line.substring(2, line.length())); return; }
		if (command.equals("DO")) { drawOval(line.substring(2, line.length())); return; }
		if (command.equals("DI")) { drawImage(line.substring(2, line.length())); return; }
		if (command.equals("DP")) { drawPolygon(line.substring(2, line.length())); return; }
		if (command.equals("GC")) { setGradientColour(line.substring(2, line.length())); return; }
		if (command.equals("CFC")) { clearFillColour(); return; }
		if (command.equals("CSC")) { clearClour(); return; }
		throw new ParseException("Unknown drawing command");
	}

	private void drawLine(String args) throws ParseException
	{
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);
		image.drawLine(x1,y1,x2,y2);
	}

	private void drawRect(String args) throws ParseException
	{
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);
		image.drawRect(x1, y1, x2, y2);
	}

	private void fillRect(String args) throws ParseException
	{
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);
		image.fillRect(x1, y1, x2, y2);
	}

	private void drawArc(String args) throws ParseException
	{
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
		image.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	private void drawOval(String args) throws ParseException
	{
		int x1 = 0;
		int y1 = 0;
		int width = 0;
		int height = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		width = getInteger(tokenizer);
		height = getInteger(tokenizer);
		image.drawOval(x1, y1, width, height);
	}

	private void drawString(String args) throws ParseException
	{
		int x = 0;
		int y = 0 ;
		String s = "";
		StringTokenizer tokenizer = new StringTokenizer(args);
		x = getInteger(tokenizer);
		y = getInteger(tokenizer);
		int position = args.indexOf("@");
		if (position == -1) throw new ParseException("DrawString string is missing");
		s = args.substring(position+1,args.length());
		image.drawString(s, x, y);
	}

	private void setColour(String colourName) throws ParseException
	{
		image.setColor(getColour(colourName));
	}

	private void setGradientColour(String args) throws ParseException
	{
		StringTokenizer tokenizer = new StringTokenizer(args);
		Color start = getColour(tokenizer.nextToken());
		Color end = getColour(tokenizer.nextToken());
		image.setGradientColor(start, end);
	}

	private void clearFillColour()
	{
		image.setGradientColor(Color.TRANSPARENT, Color.TRANSPARENT);	
	}

	private void clearClour()
	{
		image.setColor(Color.BLACK);
	}

	

	private void drawImage(String args) throws ParseException
	{
		int x = 0;
		int y = 0 ;
		int width = 0;
		int height = 0;
		String path = "";
		StringTokenizer tokenizer = new StringTokenizer(args);
		x = getInteger(tokenizer);
		y = getInteger(tokenizer);
		width = getInteger(tokenizer);
		height = getInteger(tokenizer);
		int position = args.indexOf("@");
		if (position == -1) throw new ParseException("Path is missing");
		path = args.substring(position+1,args.length());
		image.drawImage(x, y, width, height, path);
	}

	private void drawPolygon(String args) throws ParseException 
	{
		StringTokenizer tokenizer = new StringTokenizer(args);
		Double[] array = getDoubleArray(tokenizer);
		image.drawPolygon(array);
	}


	

}
