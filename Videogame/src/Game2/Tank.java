package Game2;

import java.awt.*;

public class Tank extends PolygonModel2D
{

  public Tank(double x, double y, int angle)
  {
     super(x, y, angle);
  }

  public void respondToInput(boolean[] inputIs)
  {
      if(inputIs[GameApplet.UP])  moveForwardBy(3);
      if(inputIs[GameApplet.DN])  moveBackwardBy(1);
      if(inputIs[GameApplet.LT])  rotateLeftBy(3);
      if(inputIs[GameApplet.RT])  rotateRightBy(3);
  }


  public int[][] x_data()
  {
     int[][] struct_x =
     {
        {50, -50, -50, 50},
        {40, -40, -40, 40},
        {40, -40, -40, 40},
        {45, 15, 15, 45}
     };

     return struct_x;
   }

   public int[][] y_data()
   {
     int[][] struct_y =
     {
        {30, 30, -30, -30},
        {-30, -30, -40, -40},
        {30, 30, 40, 40},
        {3, 3, -3, -3}
     };

     return struct_y;
   }


   public Color[] getColors()
   {
      Color[] c =
      {
         new Color(150, 200, 150),
         Color.black,
         Color.black,
         Color.green
      };

      return c;
   }





  public void draw(Graphics g)
  {
     super.draw(g);

     g.drawOval((int)x-15, (int)y-15, 30, 30);
  }

}



