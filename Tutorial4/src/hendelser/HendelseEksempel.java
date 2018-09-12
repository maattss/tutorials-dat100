package hendelser;

import java.time.LocalDate;
import java.util.ArrayList;

public class HendelseEksempel {

	public static void main(String[] args) {
		Hendelse sommerfesten = new Hendelse("Den Store Sommerfesten", 
				LocalDate.of(2017, 6, 7), LocalDate.of(2017, 6, 9));
		Hendelse ferie = new Hendelse("Sommerferie", 
				LocalDate.of(2017, 6, 5), LocalDate.of(2017, 8, 5));
		
		Person kulestePerson = new Person ("Mats", "Tyldum", 1994);
		Person nestKulestePerson = new Person("Per", "Hansen", 1995);
		Person teitPerson = new Person ("Ville", "Aarseth", 1994);
		
		sommerfesten.leggTilPerson(kulestePerson);
		sommerfesten.leggTilPerson(nestKulestePerson);

		ferie.leggTilPerson(kulestePerson);
		ferie.leggTilPerson(teitPerson);
		
		ArrayList<Person> personerHendelse = new ArrayList<Person>();
		personerHendelse = sommerfesten.getPersonerInvitert();
		System.out.println(sommerfesten.toString());
		for(Person person: personerHendelse){
			System.out.println(person.toString());
		}
		
		System.out.println();
		
		personerHendelse = ferie.getPersonerInvitert();
		System.out.println(ferie.toString());
		for(Person person: personerHendelse){
			System.out.println(person.toString());
		}
		
	}

}
