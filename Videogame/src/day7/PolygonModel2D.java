package day7;

import java.awt.Graphics;

public abstract class PolygonModel2D 
{
		double x;    // If you are going to do this
		double y;
		int A;
		
		int[][] struck_x = x_data();
		
		
		int[][] struck_y = y_data();

		
		public PolygonModel2D(double x, double y, int angle)
		{
			this.x = x;
			this.y = y;
			
			A = angle;
		}
		
		public abstract int[][] x_data();
		public abstract int[][] y_data();
		
		public void draw(Graphics g)
		{
			int[] xpoints = new int[4];
			int[] ypoints = new int[4];
			
			
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
