import java.lang.*;

public class Oef3 {


	public static void main( String args[]) {
		
		boolean positive = true;
		float number = 0;

		for(int i=1; i<10000; i++) {
			if (positive) {
				number = number + (1f/(float)i);
			}
			else {
				number = number - (1f/(float)i);
			}			
			

			positive = !positive;
			i++;
			
		}

		System.out.println(4*number);
	}

}