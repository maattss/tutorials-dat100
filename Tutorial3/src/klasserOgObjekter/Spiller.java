package klasserOgObjekter;

public class Spiller {
	private int ID, poengsum;
	private static int nesteID = 1;
	private String navn;
	
	public Spiller(String navn) {
		ID = nesteID;
		this.navn = navn;
		poengsum = 0;
		nesteID++;
	}
	
	public void skrivUtSpiller(){
		StringBuilder strengBygger = new StringBuilder();
		String streng = "ID: ";
		strengBygger.append(streng);
		strengBygger.append(ID);
		streng = ", Navn: ";
		strengBygger.append(streng);
		strengBygger.append(navn);
		streng = ", poengsum: ";
		strengBygger.append(streng);
		strengBygger.append(poengsum);
		System.out.println(strengBygger.toString());
	}

	public int getPoengsum(){
		return poengsum;
	}
	
	public void setPoengsum(int poengsum){
		if (poengsum > 0){
			this.poengsum = poengsum;
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
	public static int getNesteID(){
		return nesteID;
	}
}
