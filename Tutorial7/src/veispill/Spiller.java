package veispill;

public class Spiller {
	private int ID, posisjon;
	private static int nesteID = 1;
	private String navn;
	private boolean staaOverTur;
	
	public Spiller(String navn) {
		ID = nesteID;
		this.navn = navn;
		posisjon = 0;
		staaOverTur = false;
		nesteID++;
	}
	
	public String skrivUtSpiller(){
		StringBuilder strengBygger = new StringBuilder();
		String streng = "ID: ";
		strengBygger.append(streng);
		strengBygger.append(ID);
		streng = ", Navn: ";
		strengBygger.append(streng);
		strengBygger.append(navn);
		streng = ", poengsum: ";
		strengBygger.append(streng);
		strengBygger.append(posisjon);
		return strengBygger.toString();
	}

	public int getPosisjon(){
		return posisjon;
	}
	
	public void setPosisjon(int posisjon){
		if (posisjon >= 0){
			this.posisjon = posisjon;
		}
	}
	
	public String getNavn(){
		return navn;
	}
	
	public void setNavn(String navn){
		if (navn != null && navn.isEmpty()){
			this.navn = navn;	
		}
	}
	
	public int getID(){
		return ID;
	}
	public boolean getStaaOverTur(){
		return staaOverTur;
	}
	public void setStaaOverTur(Boolean staaOverTur){
		this.staaOverTur = staaOverTur;
	}
}
