package Game2;

import java.awt.*;


public class Game3 extends GameApplet
{

	  String[] action = 
			{
					"wk",
					"jp",
					"jps",
				"air",
		    };
   
   ImageLayer layer1 = new ImageLayer("../SP/mountains.gif", 0, 0, 50, 170);
   ImageLayer background2 = new ImageLayer("../SP/houses.gif", 0, 20, 6, 170);
   ImageLayer background3 = new ImageLayer("../SP/trees.gif", 0, 50, 2, 170);
   
  Sprite hero = new Sprite(200, 200, "../FG/h", 5, 10, action);

   


   public void initialize()
   {
	  

   }


   public void respondToInput()
   {
      if(input[LT])  Camera2D.moveLeftBy(1);
      if(input[RT])  Camera2D.moveRightBy(1);
      if(input[RT])  hero.walkRightBy(1);
      if(input[UP])  hero.jumpSideBy(1);

   }

   public void moveGameObjects()
   {

   }


   public void handleCollisions()
   {

   }

   public void paint(Graphics g)
   {

      layer1.draw(g);
      background2.draw(g);
      background3.draw(g);
     // hero.draw(g);

   }



}
