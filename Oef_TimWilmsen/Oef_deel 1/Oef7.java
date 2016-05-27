import java.lang.*;

public class Oef7 {


	public static void main( String args[]) {
		
		int a[] = {12,34,56,78,123,234,99,88};
		int b[] = new int[a.length];
		
		
		int j;
		for (j = 0; j < b.length; j++) {

			
			int plaats = 0;
			int i;
			int max = 0;

			for (i = 0; i < a.length; i++) 
			{
			
				if (a[i] > max)  { 
                    max = a[i]; 
                    plaats = i; 
                }
			}
			
			b[j]=max; 
            a[plaats]=0;

		}

		for (j=0;j<b.length;j++) {

			System.out.println(b[j]);
		}
		
		
	}

}