package drawapp;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class ImagePanel
{
	private Graphics graphics;

	private int width, height;

	public ImagePanel(int width, int height, Group root)
	{
		this.width = width;
		this.height = height;
		graphics = new Graphics(root);
	}
	

	/* private void setImageSize(int width, int height)
  {
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    graphics = new Graphics(root);
    clear(Color.WHITE);
    //setPreferredSize(new Dimension(width, height));
  }

/*  @Override
  protected void paintComponent(Graphics g)
  {
    g.setColor(Color.gray);
    g.fillRect(0, 0, image.getWidth(), image.getHeight());
    g.drawImage(image,0,0,this);
  }*/

	public void setBackgroundColour(Color colour)
	{
		graphics.setColor(colour);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.BLACK);
	}

	public void clear(Color colour)
	{
		setBackgroundColour(colour);
	}

	public void setColour(Color colour)
	{
		graphics.setColor(colour);
	}

	public void drawLine(int x1, int y1, int x2, int y2)
	{
		graphics.drawLine(x1, y1, x2, y2);
	}

	public void drawRect(int x1, int y1, int x2, int y2)
	{
		graphics.drawRect(x1, y1, x2, y2);
	}

	public void fillRect(int x1, int y1, int x2, int y2)
	{
		graphics.fillRect(x1, y1, x2, y2);
	}

	public void drawString(int x, int y, String s)
	{
		graphics.drawString(s,x,y);
	}

	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
	{
		graphics.drawArc(x,y,width,height,startAngle,arcAngle);
	}

	public void drawOval(int x, int y, int width, int height)
	{
		graphics.drawOval(x,y,width,height);
	}

	public void drawImage(int x, int y, int width, int height, String path) {
		graphics.drawImage(x, y, width, height, path);
		
	}
}
