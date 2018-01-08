package Game2;

import java.awt.*;

public class ImageLayer
{
   Image image;

   double x;
   double y;
   double z;
   
   double w;



   public ImageLayer(String filename, double x, double y, double z, double w)    
   {
      image = Toolkit.getDefaultToolkit().getImage(filename);

      this.x = x;
      this.y = y;
      this.z = z;
      
      this.w = w;
   }


   public void draw(Graphics g)
   {
	   for(int i = 0; i < 50; i++)
		   g.drawImage(image, (int) ((int)(x - Camera2D.x / z ) + w+i), (int)(y - Camera2D.y), null);
   }


}