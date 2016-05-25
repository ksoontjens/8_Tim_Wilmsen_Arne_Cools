import java.lang.*;

public class oef3{
	public static void main(String args[]) {
		boolean positive = true;
		float number = 0f;
		for(int i = 1;i<20000;i++){
			if(positive){
				number = number + (float)(1f/(float)i);
			}
			else{
				number = number - (float)(1f/(float)i);
			}
			positive = !positive;
			i++;
		}
		System.out.println(number);
		number = 4*number;
		System.out.println(number);
	
	}

}