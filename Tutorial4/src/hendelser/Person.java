package hendelser;

import java.util.ArrayList;

public class Person {
	private int ID, fodselsaar;
	private static int nesteID = 1;
	private String fornavn, etternavn;
	private ArrayList <Hendelse> hendelser = new ArrayList<Hendelse>();

	public Person(String fornavn, String etternavn, int fodselsaar){
		ID = nesteID;
		nesteID++;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsaar = fodselsaar;
	}
	public ArrayList<Hendelse> getHendelser(){
		return hendelser;
	}
	
	public boolean invitertTilHendelse (Hendelse hendelsen){
		return hendelser.contains(hendelsen);
	}
	
	public void leggTilHendelse(Hendelse hendelsen){
		hendelser.add(hendelsen);
		if(!hendelsen.personAlleredeInvitert(this)){
			hendelsen.leggTilPerson(this);
		}
	}
	
	public int getID(){
		return ID;
	}
	
	public int getFodselsaar(){
		return fodselsaar;
	}
	
	public void setFodselsaar(int aar){
		this.fodselsaar = aar;
	}
	
	public String getFornavn(){
		return fornavn;
	}
	
	public void setFornavn(String navn){
		this.fornavn = navn;
	}
	
	public String getEtternavn(){
		return etternavn;
	}
	
	public void setEtternavn(String navn){
		this.etternavn = navn;
	}
	public String toString(){
		String streng = new String("ID: " + ID + ", Navn: " + fornavn +
				" " + etternavn + ", Fødselsår: " + fodselsaar);
		return streng;
	}
}