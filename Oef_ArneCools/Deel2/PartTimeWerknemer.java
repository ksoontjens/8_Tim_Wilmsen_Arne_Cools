import java.lang.*;

public class PartTimeWerknemer extends Werknemer{
	int aantalUrenGewerkt;
	public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris,int aantalUren){
		super(voornaam,achternaam,wNummer,salaris);
		aantalUrenGewerkt = aantalUren;
	}

	public float getWeekLoon(){
		return aantalUrenGewerkt*salaris;
	}
	

	public void salarisVerhogen(int perc){
		if(perc>5){	
			System.out.println("Salaris voor parttime werknemers kan maximaal verhooght worden met 5%");
		}
		else{
		super.salarisVerhogen(perc);
		}
	}
}