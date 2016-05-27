import java.lang.*;

public class WerknemersTest {


	public static void main( String args[]) {
		
		//werknemer objecten
		Werknemer herman = new Werknemer("Herman", "Hermans", 3, 1000.0f);
        Werknemer lien = new Werknemer("Lien", "Brach", 3, 1000.0f);
        Werknemer ellen = new Werknemer("Ellen", "Sneyers", 3, 1000.0f);
        Werknemer tim = new Werknemer("Tim", "Tim", 4, 1000.0f);
        
        System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
        
        //loon met 10% verhogen
        herman.salarisVerhogen(10);
        
        //4 personen afdrukken
        System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
        System.out.println(lien.voornaam + " verdient " + lien.getSalaris());
        System.out.println(ellen.voornaam + " verdient " + ellen.getSalaris());
        System.out.println(tim.voornaam + " verdient " + tim.getSalaris());
        
        //parttime objecten
        PartTimeWerknemer suzy = new PartTimeWerknemer("Suzy", "Wafels", 5, 500.0f, 10);
        PartTimeWerknemer kelly = new PartTimeWerknemer("Kelly", "kellogs", 5, 500.0f, 10);
        
        System.out.println(" Suzy's weekloon is " + suzy.getWeekLoon());
        
        //salaris 5% verhogen
        suzy.salarisVerhogen(5);
        
        //met 5% erbij
        System.out.println(" Suzy's weekloon is " + suzy.getWeekLoon());
        
        //met 10%
        suzy.salarisVerhogen(10);
        
        
        System.out.println(" Herman's RSZ is " + herman.getRSZ() + " %  RSZ");
		System.out.println(" Suzy's RSZ is " + suzy.getRSZ() + " %  RSZ");
        
        // nieuw student object
        StudentWerknemer bert = new StudentWerknemer("Bert", "Blokker", 10, 10.0f, 20);
        
        //controle RSZ
        System.out.println(" Bert betaalt " + bert.getRSZ() + " %  RSZ");

        Betaalbaar BetDingen[] = new Betaalbaar[2];
        BetDingen[0] = herman;
        BetDingen[1] = new Factuur();
        
        for(int i = 0; i<2; i++) {
            
            BetDingen[i].betaal();
            
        }
        
	}

}