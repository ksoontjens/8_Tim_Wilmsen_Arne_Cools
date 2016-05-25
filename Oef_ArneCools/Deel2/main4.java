import java.lang.*;

public class main4{
	public static void main(String args[]) {
		Werknemer jan = new Werknemer("Jan","Janssens",1,1000);
		Werknemer dirk = new Werknemer("Dirk","Vanroey",2,2000);
		Werknemer peter = new Werknemer("Peter","Jansen",3,750);
		Werknemer pieter = new Werknemer("Pieter","Vandevelde",4,1750);

		jan.salarisVerhogen(10);
		dirk.salarisVerhogen(10);
/*
		System.out.println(jan.getSalaris());
		System.out.println(dirk.getSalaris());
		System.out.println(peter.getSalaris());
		System.out.println(pieter.getSalaris());
		*/

		PartTimeWerknemer hans = new PartTimeWerknemer("Hans","Hanssen",5,10,20);
		PartTimeWerknemer tom = new PartTimeWerknemer("Tom","Tomsen",6,12,38);
		hans.salarisVerhogen(11);
		//System.out.println(hans.getWeekLoon());
		//System.out.println(tom.getWeekLoon());


		//6
		hans.setRSZ(6);
		dirk.setRSZ(54);
		//System.out.println(hans.getRSZ());
		//System.out.println(tom.getRSZ());


		


	}
}