import java.lang.*;

/**
* De klasse Oef1 is een java applicatie
*
* @author	Tim Wilmsen
* @version	1.5
*/

public class EersteProg {

	/**
	* Dit is de main-functie, hier start het programma
	* @param args	Dit is een array van strings waarmee je parameters
	kunnen meegeven worden vanaf de commandline.
	*/

	public static void main( String args[]) {
		drukaf(100);
	}
	
	
	/**
	* Dit is de methode drukaf
	* @param int	dit is een nummer die wordt ingevoerd 
	wanneer de methode wordt opgeroepen
	*/
	
	
	private static void drukaf(int m) {
	
		int a;
		for (a=0; a<m; a++) {
		
			System.out.println(a);
		}	

	}

}
