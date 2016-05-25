import java.lang.*;

public class oef2{
	public static void main(String args[]) {

		String dagen[] = {"Zondag","Maandag","Dinsdag","Woensdag","Donderdag","Vrijdag","Zaterdag"};
		int i = 1;
		while(i<29){
			for(int j = 0;j<7;j++){
				if(i<29){
				System.out.println(dagen[j] + " " + i + " Februari");
				i++;
				}
			}
		}
		
	
	}

}