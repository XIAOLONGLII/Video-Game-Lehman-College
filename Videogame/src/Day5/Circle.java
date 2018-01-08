package Day5;

import java.awt.Graphics;

public class Circle
{
	int x;
	int y;
	int r;
	
	
	public Circle(int x, int y, int r)
	{
		this.x = x;
		this.y = y;
		
		this.r = r;
	}
	
	public void draw(Graphics g)
	{
		g.drawOval(x-r, y-r, 2*r, 2*r);
		
	}
	
	
	
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	public void moveLeftBy(int dx)
	{
		x -= dx;
	}
	
	public void moveRightBy(int dx)
	{
		x += dx;
	}
	
	public void moveUpBy(int dy)
	{
		y -= dy;
	}
	
	public void moveDownBy(int dy)
	{
		y += dy;
	}
	

}
