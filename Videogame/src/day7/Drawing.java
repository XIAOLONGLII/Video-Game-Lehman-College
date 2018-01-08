package day7;

import java.awt.*;
import java.applet.*; 
import java.awt.event.*;

public class Drawing extends Applet implements Runnable, KeyListener, MouseListener
{
	Image offScreen;
	Graphics offScreen_g;
	
	
	Line L = new Line(620, 750, 20, 150);
	Line L2 = new Line(270, 150, 770, 870);
	
	
	Circle c = new Circle(500, 500, 20, 22);
	
	BadCircle bc = new BadCircle(800, 300, 20, 180);
	
	Tank tank = new Tank(450, 400, 180);
	
	BadTank btank = new BadTank(500, 350, 0);
	
	
	Image background;
	
	
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
		offScreen = this.createImage(1024, 764);
		//offSreen_g.offScreen.getGraphics();
		
		background = Toolkit.getDefaultToolkit().getImage("../SP/wspy_Hunter45.gif");
	
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
			/*
			if(leftPressed)		        tank.rotateLeftBy(2);
			if(rightPressed)			tank.rotateRightBy(2);
			if(upPressed)				tank.moveForwardBy(3);
			if(downPressed)				tank.moveBackwardBy(1);
			//*/
			
			//*
			if(leftPressed)		        c.rotateLeftBy(2);
			if(rightPressed)			c.rotateRightBy(2);
			if(upPressed)				c.moveForwardBy(3);
			if(downPressed)				c.moveBackwardBy(1);
			//*/
			
			
			//BadCircle to track the circle
			
			//*/
			if(bc.leftOrRight((int)c.x, (int)c.y) > 0)   bc.rotateLeftBy(2);
			if(bc.distanceTo((int)c.x, (int)c.y) < 0)   bc.rotateLeftBy(2);
			
			if(bc.distanceTo((int)c.x, (int)c.y) > 150)  bc.moveForwardBy(2);
			//*/
			
			
			
			/*/
			if(btank.leftOrRight((int)tank.x, (int)tank.y) > 0)   btank.rotateLeftBy(2);
			if(btank.distanceTo((int)tank.x, (int)tank.y) < 0)   btank.rotateLeftBy(2);
			
			if(btank.distanceTo((int)tank.x, (int)tank.y) > 150)  btank.moveForwardBy(2);
			//*/
			
			double d = L.distanceTo((int)(c.x), (int)(c.y));
			
			
			//Not allowing to cross the line. Collission.
			if(d < c.r)
				
				c.moveBy((int)((c.r-d+10)*L.yv), (int)((d-c.r-10)*L.xv));
			
			     d = L.distanceTo((int)(c.x), (int)(c.y));
			     
			     
			 if(d < bc.r)
						
				 bc.moveBy((int)((bc.r-d+10)*L.yv), (int)((d-bc.r-10)*L.xv));
					
			     d = L.distanceTo((int)(bc.x), (int)(bc.y));
			     
			     
			     
			     if(d < c.r)
						
						c.moveBy((int)((c.r-d+10)*L2.yv), (int)((d-c.r-10)*L2.xv));
					
					     d = L2.distanceTo((int)(c.x), (int)(c.y));
					     
					     
					 if(d < bc.r)
								
						 bc.moveBy((int)((bc.r-d+10)*L2.yv), (int)((d-bc.r-10)*L2.xv));
							
					     d = L2.distanceTo((int)(bc.x), (int)(bc.y));
			
			repaint();   // Ask OS to call update
			
			try{
				 t.sleep(15);
			   }
			catch(Exception x){}
				
			
		}
	}
	
	public void update(Graphics g)
	{
		offScreen_g.clearRect(0, 0, 1024, 768);
		paint(offScreen_g);
		g.drawImage(offScreen, 0, 0, this);
	}
	
	public void paint(Graphics g)   //Does the drawing in java. should be call by the operating system and to ask OS to call paint is repaint
	{
		
		L.draw(g);
		c.draw(g);
		bc.draw(g);;
		tank.draw(g);
		btank.draw(g);
		
		g.drawImage(background, 0, 0, this);
		
		
		if(L.distanceTo((int)(c.x), (int)(c.y)) < c.r)      message = "Collission";
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
