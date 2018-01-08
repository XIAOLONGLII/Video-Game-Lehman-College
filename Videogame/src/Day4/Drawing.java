package Day4;

import java.awt.*;
import java.applet.*; 
import java.awt.event.*;

public class Drawing extends Applet implements Runnable, KeyListener, MouseListener
{
	BattleLord battlelord;
	GreenGuy greenguy;
	
	
	Sprite      guard;
	
	
	Rect r = new Rect(200, 100, 5, 3);
	Rect r2 = new Rect(300, 300, 50, 50);
	
	Thread t;
	
	boolean leftPressed = false;
	boolean rightPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	
	
	public void init()
	{
	
		battlelord = new BattleLord(100, 100);
		greenguy = new GreenGuy(200, 200);
		
		String[] action = {"die"};
		guard = new Sprite(300, 300, 20, 50, "../SP/sol", 5, 10, action);
		
		requestFocus();
		addKeyListener(this);
		addMouseListener(this);
		
		
		t = new Thread(this);
		t.start();
	}
	
	
	
	
	
	public void run()
	{
		while(true)
		{ 
			if(leftPressed)		        r.moveLeftBy(2);
			if(rightPressed)			r.moveRightBy(2);
			if(upPressed)				r.moveUpBy(2);
			if(downPressed)				r.moveDownBy(2);
			

			repaint();   // Ask OS to call paint
			
			try{
				 t.sleep(15);
			   }
			catch(Exception x){}
				
			
		}
	}
	
	public void paint(Graphics g)   //Does the drawing in java. should be call by the operating system and to ask OS to call paint is repaint
	{
		battlelord.draw(g);
		greenguy.draw(g);
		guard.draw(g);
		r.draw(g);
		//r2.draw(g);
		//g.drawString(message, 0, 25);
		
		if(r.hasCollidedWith(guard))   guard.moving = true;
		if(r.hasCollidedWith(greenguy))   greenguy.moving = true;

	}
	
	
	String message = "Outside";
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		
		int my = e.getY();
		
		if(r.hasCollidedWith(r2))          message = "Collided";
 
		else                               message = "Missed";  
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void keyPressed(KeyEvent e)
	{
		//Record which keys have been pressed
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)         leftPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)        rightPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_UP)           upPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)         downPressed = true;
	
	}
	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)			leftPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)			rightPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_UP)			upPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)			downPressed = false;
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
