package day7;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Sprite extends Rect
{
	
	Animation[] animation;
	
	
	public static final int UP = 0;
	public static final int DN = 1;
	public static final int LT = 2;
	public static final int RT = 3;
	
	int action = UP;
	
	boolean moving = false;
	
	
	//Image image;
	
	
	public Sprite
	(
			int 		x,
			int 		y,
			int         w,
			int         h,
			String 		filename,
			int 		count, 
			int 		duration, 
			String[] 	action
	)
	{
		
		
		super(x, y, w, h);
		
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
	
	public void moveUpBy(int dy)
	{
		y -= dy;
		
		action = UP;
		
		moving = true;
	}
	public void moveDownBy(int dy)
	{
		y += dy;
		
		action = DN;
		
		moving = true;
	}
	
	public void draw(Graphics g)
	{
		if(moving)		g.drawImage(animation[action].nextImage(), x, y, null);
		
		else			g.drawImage(animation[action].staticImage(), x, y, null);	
		
		moving = false;
		g.drawRect(x, y, w, h);
	}
	

}
