package Game2;

import java.awt.*;
import java.awt.Image;
import java.awt.Toolkit;

public class Sprite3D extends Object3D
{
	//Image image;
	
	
	double x;
	double y;
	double z;
	
	int w;
	int h;
	
	
	Animation[] animation;
	
	
	public static final int IN = 0;
	public static final int OT = 1;
	public static final int LT = 2;
	public static final int RT = 3;
	
	int action = IN;
	
	boolean moving = false;
	

	
	//double d = 800; // d is not suppose to be here.
	
	//int x_origin = 512;
	//int y_origin = 380;
	
	public Sprite3D
	(
			String filename,
			double x, 
			double y, 
			double z, 
			int w, 
			int h,
			int count, 
			int duration, 
			String[] action
		)
	{
		
		//image = Toolkit.getDefaultToolkit().getImage(filename);
		
		this.x = x;
		this.y = y;
		this.z = z; 
		
		this.w = w;
		this.h = h;
		
        animation = new Animation[action.length];
		
		for(int i = 0; i < animation.length; i++)
		
		//image = Toolkit.getDefaultToolkit().getImage(filename);
		animation[i] = new Animation(filename +"_" + action[i] + "_" , count, duration);
		
	}
	

	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
		
		moving = true;
	}
	
	public void moveLeftBy(int dx)
	{
		x -= dx;
		
		action = LT;
		
		moving = true;
	}
	
	public void moveRightBy(int dx)
	{
		x += dx;
		
		action = RT;
		
		moving = true;
	}

	public void moveInBy(int dz)
	{
		x -= dz;
		
		action = IN;
		
		moving = true;
	}
	
	public void moveOutBy(int dz)
	{
		x = dz;
		
		action = OT;
		
		moving = true;
	}
	
	
	public void draw(Graphics g)
	{
		double c = d/z;
		if(z > 0)
		{
			if(moving)
				g.drawImage(animation[action].nextImage(), (int)(c*(x - w/2)) + x_origin, (int)(c*(y - h)) + y_origin, (int)(c*w), (int)(c*h), null);
			else
				g.drawImage(animation[action].staticImage(), (int)(c*(x - w/2)) + x_origin, (int)(c*(y - h)) + y_origin, (int)(c*w), (int)(c*h), null);
		}
		moving = false;
	}

}
