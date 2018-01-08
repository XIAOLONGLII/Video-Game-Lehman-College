package day6;

import java.awt.Graphics;
/*
public class Tank1122
{
	double x;    // If you are going to do this
	double y;
	int A;
	
	int[][] struck_x =
		{
		{50, -50, -50, 50},
		{40, -40, -40, 40},
		{40, -40, -40, 40},
		{45, 15, 15, 45}
		};
	
	
	int[][] struck_y =
	{
		{30, 30, -30, -30},
		{-30, -30, -40, -40},
		{30, 30, 40, 40},
		{3, 3, -3, -3}
		
	};
	
	
	//int[] bodyy = {30, 30, -30, -30};
	//int[] bodyx = {50, -50, -50, 50};
	
	//int[] ltracky = {-30, -30, -40, -40};
	//int[] ltrackx = {40, -40, -40, 40};
	
	//int[] rtracky = {30, 30, 40, 40};
	//int[] rtrackx = {40, -40, -40, 40};
	
	//int[] guny = {3, 3, -3, -3};
	//int[] gunx = {45, 15, 15, 45};

	
	public Tank1122(double x, double y, int angle)
	{
		this.x = x;
		this.y = y;
		
		A = angle;
	}
	
	public void draw(Graphics g)
	{
		int[] xpoints = new int[4];
		int[] ypoints = new int[4];
		
		//double radians = A * Math.PI / 180;
		
		double cosA = Lookup.cos[A];
		double sinA = Lookup.sin[A];
		
		for(int poly = 0; poly < struck_x.length; poly++)
		{
			for(int vert = 0; vert < struck_x[poly].length; vert++)
			{
				xpoints[vert] = (int)(struck_x[poly][vert]*cosA - struck_y[poly][vert]*sinA + x);
				ypoints[vert] = (int)(struck_x[poly][vert]*sinA + struck_y[poly][vert]*cosA + y);
			}
			
			g.drawPolygon(xpoints, ypoints, struck_x[poly].length);
		}
		
		g.drawOval((int)x-15, (int)y-15, 30, 30);
		
		
	}
	
	public void moveForwardBy(int d)
	{
		x += d * Lookup.cos[A];
		y += d * Lookup.sin[A];
		
	}
	
	public void moveBackwardBy(int d)
	{
		x -= d * Lookup.cos[A];
		y -= d * Lookup.sin[A];
		
	}
	public void rotateLeftBy(int degrees)
	{
		A -= degrees;
		
		if(A < 0) A += 360;
		
		//A = (A - degrees) % 360;  this works also instead of the 2 lines above
		
	}
	public void rotateRightBy(int degrees)
	{
		A += degrees;
		
		if(A > 359) A -= 360;
	}
	
	
	
	

}
*/