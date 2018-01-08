package day8;

public class BadTank extends Tank
{

   public BadTank(double x, double y, int angle)
   {
      super(x, y, angle);
   }


   public double leftOrRight(int x, int y)
   {
      return (x - this.x) * Lookup.sin[A] - (y - this.y) * Lookup.cos[A];
   }


   public double distanceTo(int x, int y)
   {
      return (x - this.x) * Lookup.cos[A] + (y - this.y) * Lookup.sin[A];
   }
}
