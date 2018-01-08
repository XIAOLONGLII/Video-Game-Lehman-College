package Game2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Sprite 
{
	static int x;
	
	static int y;
	
	Animation[] animation;
	
	
	public static final int WK = 0;
	public static final int JP = 1;
	public static final int JPS = 2;
	public static final int AiA = 3;
	
	int action = WK;
	
	boolean moving = false;
	
	
	//Image image;
	
	
	public Sprite
	(
			int 		x,
			int 		y,
			String 		filename,
			int 		count, 
			int 		duration, 
			String[] 	action
	)

	{
		this.x = x;
		this.y = y;
		
		
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
	
	public void jumpUpBy(int dx)
	{
		x -= dx;
		
		action = JP;
		
		moving = true;
	}
	
	public void walkRightBy(int dx)
	{
		x += dx;
		
		action = WK;
		
		moving = true;
	}
	
	public void jumpSideBy(int dx)
	{
		x += dx;
		
		action = JPS;
		
		moving = true;
	}
	public void moveAiABy(int dy)
	{
		y += dy;
		
		action = AiA;
		
		moving = true;
	}
	
	public void draw(Graphics g)
	{
		if(moving)		g.drawImage(animation[action].nextImage(), x, y, null);
		
		else			g.drawImage(animation[action].staticImage(), x, y, null);	
		
		moving = false;
	}
	

}
