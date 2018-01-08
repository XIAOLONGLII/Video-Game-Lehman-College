package Day5;

import java.awt.*;
import java.applet.*; 
import java.awt.event.*;

public class Drawing extends Applet implements Runnable, KeyListener, MouseListener
{
	Line L = new Line(800, 750, 20, 200);
	
	Circle c = new Circle(500, 500, 20);
	
	Tank tank = new Tank(450, 400, 180);
	
	
	BattleLord battlelord;
	GreenGuy greenguy;
	
	
	Sprite      guard;
	
	//Line L;
	
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
			//*
			if(leftPressed)		        tank.rotateLeftBy(3);
			if(rightPressed)			tank.rotateRightBy(3);
			if(upPressed)				tank.moveForwardBy(2);
			if(downPressed)				c.moveDownBy(2);
			//*/
			
			
			/*
			if(leftPressed)		        tank.moveLeftBy(2);
			if(rightPressed)			tank.moveRightBy(2);
			if(upPressed)				tank.moveUpBy(2);
			if(downPressed)				tank.moveDownBy(2);
			
			//*/
			double d = L.distanceTo(c.x, c.y);
			
			
			//Not allowing to cross the line. Collission.
			if(d < c.r)
				
				c.moveBy((int)((c.r-d)*L.yv), (int)((d-c.r)*L.xv));
			
			repaint();   // Ask OS to call paint
			
			try{
				 t.sleep(15);
			   }
			catch(Exception x){}
				
			
		}
	}
	
	public void paint(Graphics g)   //Does the drawing in java. should be call by the operating system and to ask OS to call paint is repaint
	{
		
		L.draw(g);
		c.draw(g);
		
		tank.draw(g);
		
		
		if(L.distanceTo(c.x, c.y) < c.r)      message = "Collission";
		else								  message = "No";
				
		g.drawString(message, 10, 30);
		
		
		
		/*
		battlelord.draw(g);
		greenguy.draw(g);
		guard.draw(g);
		r.draw(g);
		//r2.draw(g);
		//g.drawString(message, 0, 25);
		
		if(r.hasCollidedWith(guard))   guard.moving = true;
		if(r.hasCollidedWith(greenguy))   greenguy.moving = true;
		//*/

	}
	
	
	String message = "0";
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		
		int my = e.getY();
		
		message = "d = " + L.distanceTo(mx, my);        

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
