import java.lang.*;

public class oef5 {
	public static void main(String args[]) {
		for(int i=1;i<100;i++){
			for(int j = 1;j<100;j++){

				if(j != 1 && j != i){
					if(i%j == 0){
						break;
					}
				
				if(i==(j-1) && i != 1){System.out.println(i);}
				
				}

			}

		
		}
	}

}