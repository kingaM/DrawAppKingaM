package drawapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

public class Parser
{
  private BufferedReader reader;
  private ImagePanel image;
  private MainWindow frame;

  public Parser(Reader reader, ImagePanel image, MainWindow frame)
  {
    this.reader = new BufferedReader(reader);
    this.image = image;
    this.frame = frame;
  }

  public void parse()
  {
    try
    {
      /*String line = reader.readLine();
    	
      while (line != null)
      {
        parseLine(line);
        line = reader.readLine();
      }
      */
    	
    	String[] lines = {
    			"DO 30 30 100 150",
    			"DO 0 0 499 299",
    			"DA 100 100 90 120 0 180"
    			
    			/*"DL 40 250 290 250",
    			"DL 40 250 40 50",
    			"DS 50 270 @CDs",
    			"DS 98 270 @DVDs",
    			"DS 146 270 @Books",
    			"DS 190 270 @Clothes",
    			"DS 248 270 @Shoes",
    			"DL 40 250 35 250",
    			"DS 10 255 @0",
    			"DL 40 200 35 200",
    			"DS 10 205 @50",
    			"DL 40 150 35 150",
    			"DS 10 155 @100",
    			"DL 40 100 35 100",
    			"DS 10 105 @150",
    			"SC blue",
    			"FR 40 190 50 60",
    			"SC green",
    			"FR 90 110 50 140",
    			"SC red",
    			"FR 140 130 50 120",
    			"SC yellow",
    			"FR 190 155 50 95",
    			"SC magenta",
    			"FR 240 110 50 140" */
    	};
    	
    	for(String s : lines) {
    		parseLine(s);
    	}
    	
    }
    /*catch (IOException e)
    {
      frame.postMessage("Parse failed.");
      return;
    }*/
    catch (ParseException e)
    {
      frame.postMessage("Parse Exception: " + e.getMessage());
      return;
    }
    frame.postMessage("Drawing completed");
  }

  private void parseLine(String line) throws ParseException
  {
    if (line.length() < 2) return;
    String command = line.substring(0, 2);
    if (command.equals("DL")) { drawLine(line.substring(2,line.length())); return; }
    if (command.equals("DR")) { drawRect(line.substring(2, line.length())); return; }
    if (command.equals("FR")) { fillRect(line.substring(2, line.length())); return; }
    if (command.equals("SC")) { setColour(line.substring(3, line.length())); return; }
    if (command.equals("DS")) { drawString(line.substring(3, line.length())); return; }
    if (command.equals("DA")) { drawArc(line.substring(2, line.length())); return; }
    if (command.equals("DO")) { drawOval(line.substring(2, line.length())); return; }


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
    if (colourName.equals("black")) { image.setColour(Color.BLACK); return;}
    if (colourName.equals("blue")) { image.setColour(Color.BLUE); return;}
    if (colourName.equals("cyan")) { image.setColour(Color.CYAN); return;}
    if (colourName.equals("darkgray")) { image.setColour(Color.DARKGRAY); return;}
    if (colourName.equals("gray")) { image.setColour(Color.GRAY); return;}
    if (colourName.equals("green")) { image.setColour(Color.GREEN); return;}
    if (colourName.equals("lightgray")) { image.setColour(Color.LIGHTGRAY); return;}
    if (colourName.equals("magenta")) { image.setColour(Color.MAGENTA); return;}
    if (colourName.equals("orange")) { image.setColour(Color.ORANGE); return;}
    if (colourName.equals("pink")) { image.setColour(Color.PINK); return;}
    if (colourName.equals("red")) { image.setColour(Color.RED); return;}
    if (colourName.equals("white")) { image.setColour(Color.WHITE); return;}
    if (colourName.equals("yellow")) { image.setColour(Color.YELLOW); return;}
    throw new ParseException("Invalid colour name");
  }

  private int getInteger(StringTokenizer tokenizer) throws ParseException
  {
    if (tokenizer.hasMoreTokens())
      return Integer.parseInt(tokenizer.nextToken());
    else
      throw new ParseException("Missing Integer value");
  }
}
