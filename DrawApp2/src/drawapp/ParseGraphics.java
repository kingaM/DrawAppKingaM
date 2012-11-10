package drawapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;



public class ParseGraphics {
	
	private ArrayList<String> ccode = new ArrayList<String>();
	ImagePanel image;
	
	public ParseGraphics(ArrayList<String> ccode, ImagePanel image)
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
		image.drawString(x,y,s);
	}

	private void setColour(String colourName) throws ParseException
	{
		image.setColour(getColour(colourName));
	}

	private void setGradientColour(String args) throws ParseException
	{
		StringTokenizer tokenizer = new StringTokenizer(args);
		Color start = getColour(tokenizer.nextToken());
		Color end = getColour(tokenizer.nextToken());
		image.setGradientColour(start, end);
	}

	private void clearFillColour()
	{
		image.setGradientColour(Color.TRANSPARENT, Color.TRANSPARENT);	
	}

	private void clearClour()
	{
		image.setColour(Color.BLACK);
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

	private int getInteger(StringTokenizer tokenizer) throws ParseException
	{
		if (tokenizer.hasMoreTokens())
			return Integer.parseInt(tokenizer.nextToken());
		else
			throw new ParseException("Missing Integer value");
	}

	private Double[] getDoubleArray(StringTokenizer tokenizer) throws ParseException
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
