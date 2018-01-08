package day6;

public class BattleLord extends Sprite{
	
		private static final String[] action =
			{
					"up",
					"dn",
					"lt",
					"rt",
		    };
		
		public BattleLord(int x, int y)
		{
			super(x, y, 110, 115, "../SP/bl", 5, 10, action);
			
		}

	}



