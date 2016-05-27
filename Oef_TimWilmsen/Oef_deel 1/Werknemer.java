public class Werknemer implements Betaalbaar {

	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris; 
    private float RSZpercentage = 33.0f;
    
    public Werknemer(String voornaam, String achternaam, int wNummer, float sal) {
        
        //this gebruikt de publieke variabele als de naamgeving hetzelfde is
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        werknemerNummer = wNummer;
        salaris = sal;
    }
    

	public void salarisVerhogen(int perc) {
		
		salaris += salaris * (perc/100.0);
        
	}
    
    public float getSalaris() {
        
        return salaris;
        
    }
    
    public void setRSZ(float rsz) {
        
        if(rsz>100) {
            
            System.out.println("Fout: Te groot percentage");
            
        }
        
        RSZpercentage = rsz;
    }
    
    public float getRSZ() {
        
        return RSZpercentage;
        
    }
    
    public void betaal() {
        
        System.out.println("Betaal " + salaris + " aan " + voornaam);
        
    }

}