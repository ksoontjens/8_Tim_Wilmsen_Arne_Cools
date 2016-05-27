import java.lang.*;

public class Oef6 {


	public static void main( String args[]) {
		
		int a[] = {12,34,56,78,123,234,99,88};
		
		int i;
		int max = 0;

		for (i = 0; i < a.length; i++) 
		{
			
			if (a[i] > max)  
			{ 
				max = a[i]; 
			}
		}
		System.out.println("Het grootste getal = " +max);
		
		
	}

}