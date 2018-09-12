package application;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.Alert;

/*
 * Oppgave d, markerte metoder og variabler fra andre deloppgaver
 */
public class Person implements Serializable{
	private static final long serialVersionUID = 2;
	private int ID;
	transient private static int nesteID = 1;
	private String fornavn;
	private String etternavn;
	private int fodselsaar;
	private ArrayList<Hendelse> hendelser; // Oppgave h)
	
	/*
	 * Konstrukt�ren var ikke spesifisert i oppgaveteksten. Dette er bare
	 * en m�te den kan gj�res p�. Poenget er at man m� ha en metode
	 * � sette alle egenskapene p� selv de som ikke har settere.
	 */
	public Person(String fornavn, String etternavn, int fodselsaar) {
		this.ID = nesteID;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsaar = fodselsaar;
		hendelser = new ArrayList<>();
		nesteID++;
	}
	
	// Trengs for oppgave j
	public ArrayList<Hendelse> getHendelser() {
		return hendelser;
	}
	
	// Trengs for oppgave k
	public boolean invitertTilHendelse(Hendelse hendelsen) {
		return hendelser.contains(hendelsen);
	}
	
	// Oppgave k
	public void leggTilHendelse(Hendelse hendelsen) {
		hendelser.add(hendelsen);
		if (!hendelsen.personInvitert(this)) hendelsen.leggTilPerson(this);
	}
	public void fjernHendelse(Hendelse hendelsen) {
		hendelser.remove(hendelsen);
		if(!hendelsen.personInvitert(this)) hendelsen.fjernPerson(this);
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public int getID() {
		return ID;
	
	}
	
	public int getFodselsaar() {
		return fodselsaar;
	}
	
	@Override public String toString() {
		return "Person " + ID + ": " + fornavn + " " + etternavn + 
				", født i " + fodselsaar;
	}
}
