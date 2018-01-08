package Day5;

import java.awt.Graphics;

public class Tank 
{
	int x;
	int y;
	int A;
	
	
	int[] bodyx = {30, 30, -30, -30};
	int[] bodyy = {50, -50, -50, 50};
	
	int[] ltrackx = {-30, -30, -40, -40};
	int[] ltracky = {40, -40, -40, 40};
	
	int[] rtrackx = {30, 30, 40, 40};
	int[] rtracky = {40, -40, -40, 40};
	
	int[] gunx = {3, 3, -3, -3};
	int[] guny = {45, 15, 15, 45};
	
	
	public Tank(int x, int y, int angle)
	{
		this.x = x;
		this.y = y;
		
		A = angle;
	}
	
	public void draw(Graphics g)
	{
		int[] xpoints = new int[4];
		int[] ypoints = new int[4];
		
		double radians = A + Math.PI / 180;
		
		double cosA = Math.cos(radians);
		double sinA = Math.sin(radians);
		
		for(int vertex = 0; vertex < 4; vertex++)
		{
			xpoints[vertex] = (int)(bodyx[vertex]*cosA - bodyy[vertex]*sinA) + x;
			ypoints[vertex] = (int)(bodyx[vertex]*sinA + bodyy[vertex]*cosA) + y;
		}
		g.drawPolygon(xpoints, ypoints, 4);
		
		
		for(int vertex = 0; vertex < 4; vertex++)
		{
			xpoints[vertex] = (int)(ltrackx[vertex]*cosA - ltracky[vertex]*sinA) + x;
			ypoints[vertex] = (int)(ltrackx[vertex]*sinA + ltracky[vertex]*cosA) + y;
		}
		
		g.drawPolygon(xpoints,ypoints, 4);
		
		for(int vertex = 0; vertex < 4; vertex++)
		{
			xpoints[vertex] = (int)(rtrackx[vertex]*cosA - rtracky[vertex]*sinA) + x;
			ypoints[vertex] = (int)(rtrackx[vertex]*sinA + rtracky[vertex]*cosA) + y;
		}
		
		g.drawPolygon(xpoints, ypoints, 4);
		
		for(int vertex = 0; vertex < 4; vertex++)
		{
			xpoints[vertex] = (int)(gunx[vertex]*cosA - guny[vertex]*sinA) + x;
			ypoints[vertex] = (int)(gunx[vertex]*sinA + guny[vertex]*cosA) + y;
		}
		
		g.drawPolygon(xpoints, ypoints, 4);
		
		g.drawOval(x-15, y-15, 30, 30);
		
	}
	
	public void moveForwardBy(int d)
	{
		x += d * Math.cos(A * Math.PI / 180);
		y += d * Math.sin(A * Math.PI / 180);
		
	}
	public void rotateLeftBy(int degrees)
	{
		A -= degrees;
	}
	public void rotateRightBy(int degrees)
	{
		A += degrees;
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
