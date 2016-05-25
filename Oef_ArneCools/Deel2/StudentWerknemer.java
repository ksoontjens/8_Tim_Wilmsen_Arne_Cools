import java.lang.*;

public class StudentWerknemer extends PartTimeWerknemer{

	public StudentWerknemer(String voornaam, String achternaam, int wNummer, float salaris,int aantalUren){
		super(voornaam, achternaam, wNummer, salaris, aantalUren);
		super.setRSZ(5);
	}
	
}