package Day1;

import java.awt.*;
import java.applet.*; 

public class Drawing extends Applet
{
	
	
	public void paint(Graphics g)   //Does the drawing in java
	{
		//g.drawLine(10, 10, 100, 100);
		drawPoint(10, 10, g);
		drawHorzLine(100, 200, 100, g);
		drawVertLine(100, 100, 200, g);
		drawAARect(200, 200, 50, 100, g);
		drawAARect(500, 300, 300, 140, g);
		drawLine(0, 0, 400, 100, g);
		drawLine(0, 0, 100, 400, g);
		drawLine(500, 500, 700, 500, g);
		drawLine(500, 500, 500, 700, g);
		
		int[] xPoints = {300, 270, 340, 390};
		int[] yPoints = { 300, 390, 420,330};
		
		g.drawPolygon(xPoints, yPoints, 4);
	}

	
	public void drawPoint(int x, int y, Graphics g)
	{
		g.drawLine(x, y, x, y);
	}
	
	public void drawLine(int x1, int y1, int x2, int y2, Graphics g)
	{
		int dx = x2 - x1;
		int dy = y2 - y1;
		
		double m = dy/(double)dx;
		
		if(dy == 0)
		{
			drawHorzLine(x1, x2, y1, g);
		}
		
		if(dx == 0)
		{
			drawVertLine(x1, y1, y2, g);
		}
		
		if(m < 1)
		{
			double y = y1;
		
			for (int x = x1; x< x2; x++)
			{
				drawPoint(x, (int)y, g);
				y += m;
			}
		}
		
		if (m > 1)
		{
			double x = x1;
			
			for(int y = y1; y < y2; y++)
			{
				drawPoint((int)x, y, g);
				x += 1/m;
				
			}
		}
		
	}
	
	public void drawHorzLine(int x1, int x2, int y, Graphics g)
	{
		for (int x = x1; x < x2; x++)
		{
			drawPoint(x, y, g);
		}
		
	}
	
	public void drawVertLine(int x, int y1, int y2, Graphics g)
	{
		for(int y = y1; y < y2; y++)
		{
			drawPoint(x, y, g);
		}
	}
	public void drawAARect(int x, int y, int w, int h, Graphics g)
	{
		drawVertLine(x, y, y+h, g);
		drawHorzLine(x, x+w, y, g);
		drawHorzLine(x, x+w, y+h, g);
		drawVertLine(x+w, y, y+h, g);
		
	}
}
