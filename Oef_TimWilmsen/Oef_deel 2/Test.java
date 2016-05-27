import java.lang.*;


/**
*
*   @author         Tim Wilmsen
*   @version 1.5
*/

public class Test {

    /**
    *
    *   Dit is de main methode
    *   @param args     Dit is de test
    */

	public static void main( String args[]) {

        
        int a[] = {12,34,56,78,123,234,99,88};
		int b[] = new int[a.length];
		
		
		int j;
        for (j = 0; j < b.length; j++) {
            
            
            int plaats = 0;
            int max = 0;
            int i;
            
            for(i = 0; i < a.length; i++) {
                
                if(a[i] > max) {
                    max = a[i];
                    plaats = i;
                }
                
            }
            
            b[j] = max;
            a[plaats] = 0;
            
        }
        
        for(j = 0; j < b.length; j++) {
            System.out.println(b[j]);
        }

	}

}