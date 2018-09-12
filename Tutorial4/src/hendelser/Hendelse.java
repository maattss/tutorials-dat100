package hendelser;
import java.time.LocalDate;
import java.util.ArrayList;


public class Hendelse {
	private String beskrivelse;
	private LocalDate startDato;
	private LocalDate sluttDato;
	private ArrayList<Person> invitertePersoner = new ArrayList <Person> ();
		
	public Hendelse(String beskrivelse, LocalDate startDato, LocalDate sluttDato) {
		this.beskrivelse = beskrivelse;
		this.startDato = startDato;
		setSluttDato(sluttDato);
	}
	public boolean personAlleredeInvitert(Person personen){
		return invitertePersoner.contains(personen);
	}
	
	public void leggTilPerson(Person person){
		ArrayList<Hendelse> hendelser = new ArrayList<Hendelse>();
		hendelser = person.getHendelser();
		for(Hendelse hendelse: hendelser){
			if (overlapper(hendelse, this)){
				System.out.println("Den nye hendelse " + getBeskrivelse() +
						" kolliderer med hendelsen " + hendelse.getBeskrivelse());
			}
		}
		invitertePersoner.add(person);
		if (!person.invitertTilHendelse(this)) { 
			person.leggTilHendelse(this);
		}
	}
		
	public ArrayList<Person> getPersonerInvitert(){
		return invitertePersoner;
	}
	
	public String getBeskrivelse() { 
		return beskrivelse;
	}
	
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	public LocalDate getStartDato() {
		return startDato;
	}
	
	public void setStartDato(LocalDate startDato) {
		if (sluttDato != null && startDato.compareTo(sluttDato) > 0) {
			throw new IllegalArgumentException("En hendelse kan ikke slutte før den starter!");
		}
		this.startDato = startDato;
	}
	
	public LocalDate getSluttDato() {
		return sluttDato;
	}
	
	public void setSluttDato(LocalDate sluttDato) {
		if (startDato != null && startDato.compareTo(sluttDato) > 0) {
			throw new IllegalArgumentException("En hendelse kan ikke slutte før den starter!");
		}
		this.sluttDato = sluttDato;
	}

	public String toString() {
		String resultat = "Hendelse: " + beskrivelse + ",\n" +
				"starter " + startDato.toString() + " og slutter " + sluttDato.toString();
		return resultat;
	}
	
	/*
	 * Du velger selv hvilken versjon av metoden "overlapper" du bruker for oppgave j.
	 * 
	 * Dette er et eksempel på en ikke-statisk metode og en statisk metode som gjør det samme,
	 * og illustrerer forskjellen mellom statiske og ikke-statiske metoder.
	 */
	public boolean overlapper(Hendelse denAndreHendelsen) {
		LocalDate start2 = denAndreHendelsen.getStartDato();
		LocalDate slutt2 = denAndreHendelsen.getSluttDato();
		
		if (sluttDato.compareTo(start2) < 0) return false;
		if (slutt2.compareTo(startDato) < 0) return false;
		
		return true;
	}
	
	public static boolean overlapper(Hendelse hendelseEn, Hendelse hendelseTo) {
		LocalDate start1 = hendelseEn.getStartDato();
		LocalDate start2 = hendelseTo.getStartDato();
		LocalDate slutt1 = hendelseEn.getSluttDato();
		LocalDate slutt2 = hendelseTo.getSluttDato();
		
		if (slutt1.compareTo(start2) < 0) return false;
		if (slutt2.compareTo(start1) < 0) return false;
		
		return true;
	}
}
