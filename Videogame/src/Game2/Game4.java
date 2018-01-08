package Game2;

import java.awt.*;


public class Game4 extends GameApplet
{

	Sprite3D[] gg = new Sprite3D[25];
	
	private static final  String[] action = 
			{
					"up",
					"dn",
					"lt",
				    "rt",
		    };




   public void initialize()
   {
	   for(int x = 0; x < 250; x+= 50)
		   
		   for(int z = 100; z < 350; z+= 50)
		   
			   gg[x/50 +5 *((z-100)/50)] = new Sprite3D("../SP/g", x, -100, z, 20, 50, 5, 5, action);

   }


   public void respondToInput()
   {
	   for(int i = 0; i < 25; i++)
	   {
		 if(input[LT])  gg[0].moveBy(-5, 0);
         if(input[RT])  gg[0].moveBy(5, 0);
      
         if(input[UP])  gg[0].moveBy(0, 0);
         if(input[DN])  gg[0].moveBy(0, 0);
	   }


   }

   public void moveGameObjects()
   {

   }


   public void handleCollisions()
   {

   }

   public void paint(Graphics g)
   {
	   for(int i = 24; i <= 0; i--)
		   
		   gg[i].draw(g);

   }



}
