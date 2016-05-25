import java.lang.*;

public class Werknemer implements Betaalbaar{
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	protected float RSZ = 33;
	
	public Werknemer(String voornaam, String achternaam, int wNummer, float salaris)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		werknemerNummer = wNummer;
		this.salaris = salaris;
	}

	public void salarisVerhogen(int perc)
	{
		salaris+=salaris*(perc/100.0);

	}
	public float getSalaris()
	{
		return salaris;
	}
	public void setRSZ(float RSZ){
		this.RSZ = RSZ;
	}
	public float getRSZ(){
		return RSZ;
	}


	public void betaal(){
	System.out.println("Betaal " + salaris+" aan " + voornaam);
	}
}