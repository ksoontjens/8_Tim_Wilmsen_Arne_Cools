import java.lang.*;

public class WerknemersTest {


	public static void main( String args[]) {
		
		Werknemer herman = new Werknemer("Herman", "Hermans", 3, 1000.0f);
        System.out.println( herman.werknemerNummer);
        
        System.out.println( herman.getSalaris() );
        
        herman.salarisVerhogen(10);
        
        System.out.println( herman.getSalaris() );
        
	}

}