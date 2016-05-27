public class PartTimeWerknemer extends Werknemer {
    
    int aantalUrenGewerkt;

	public PartTimeWerknemer(String voornaam, String achternaam, int wNum, float sal, int aantalUren) {
        
        //moet op de eerste lijn
        //zelfde variablen als de constructor van deze klasse
        super(voornaam, achternaam, wNum, sal);
        
        aantalUrenGewerkt = aantalUren;
        
    }
    
    public float getWeekLoon() {
        
        return aantalUrenGewerkt * salaris;
        
    }
    
    public void salarisVerhogen(int perc) {
        
        if(perc > 5) {
            
            perc = 0;
            System.out.println("Fout: slechts 5% opslag toegestaan");
            
        }
        
        else {
            
            super.salarisVerhogen(perc);
            
        }
    }

}