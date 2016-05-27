import java.lang.*;

public class Oef2 {


	public static void main( String args[]) {
		
		int weekdag = 0;
		
		for (int dag=1; dag<29; dag++) 
		{
			if (weekdag == 0) { System.out.print("Zondag "); }	
			if (weekdag == 1) { System.out.print("Maandag "); }
			if (weekdag == 2) { System.out.print("Dinsdag "); }
			if (weekdag == 3) { System.out.print("Woensdag "); }
			if (weekdag == 4) { System.out.print("Donderdag "); }
			if (weekdag == 5) { System.out.print("Vrijdag "); }
			if (weekdag == 6) { System.out.print("Zaterdag "); }

			weekdag++;
			if (weekdag > 6) { weekdag = 0; }
			System.out.println(dag + " februari");
		}

	}

}