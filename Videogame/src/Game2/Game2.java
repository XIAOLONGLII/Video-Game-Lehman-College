package Game2;

import java.awt.*;

public class Game2 extends GameApplet
{
   Tank     tank  = new Tank(100, 100, 0);
   BadTank  btank = new BadTank(800, 600, 0);



   public void initialize()
   {

   }


   public void respondToInput()
   {
       tank.respondToInput(input);
   }

   public void moveGameObjects()
   {
      btank.chase(tank);

   }


   public void handleCollisions()
   {

   }

   public void paint(Graphics g)
   {

      tank.draw(g);

      btank.draw(g);

   }



}