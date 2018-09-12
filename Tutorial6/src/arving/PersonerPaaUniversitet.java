package arving;

import java.util.ArrayList;

public class PersonerPaaUniversitet {

	private static ArrayList <Person> personer;
	
	public static void main(String[] args) {
		personer = new ArrayList<Person>();
		
		//Rom
		Rom auditorium1 = new Rom('A', 1, 01, 200);
		Rom grupperom1 = new Rom('A', 2, 06, 30);
				
		//Emner
		Emne dat100 = new Emne("DAT100", "Objektorientert programmering", 'V');
		Emne dat200 = new Emne("DAT200", "Algoritmer og datastrukturer", 'V');
		Emne mat100 = new Emne("MAT100", "Matematiske metoder 1", 'V');
		Emne mat200 = new Emne("MAT200", "Matematiske metoder 2", 'V');
		Emne pet100 = new Emne("PET100", "Boring", 'V');
				
		//Vanlig ansatt
		Ansatt ansatt1 = new Ansatt ("Ola", "Nordmann", 1960, 1,"Studieveileder", 350000);
		personer.add(ansatt1);
		Ansatt ansatt2 = new Ansatt ("Hans", "Hansen", 1970, 2,"Kokk", 300000);
		personer.add(ansatt2);
				
		//Student
		Student student1 = new Student("Jon", "Jonsen", 1994, "Data", 3);
		student1.leggTilEmne(dat100);
		student1.leggTilEmne(dat200);
		personer.add(student1);
				
		Student student2 = new Student("Henrik", "Henriksen", 1996, "Matematikk", 2);
		student2.leggTilEmne(mat100);
		student2.leggTilEmne(mat200);
		personer.add(student2);
				
		//Vitenskaplig ansatt
		VitenskapeligAnsatt vAnsatt1 = new VitenskapeligAnsatt("Kristin", "Andreassen",
				1950, 3, "Professor", 700000, "Data");
		vAnsatt1.leggTilUndervisningemne(dat100);
		vAnsatt1.leggTilUndervisningemne(dat200);
		personer.add(vAnsatt1);
				
		VitenskapeligAnsatt vAnsatt2 = new VitenskapeligAnsatt("Lars", "Larsen",
				1955, 4, "Professor", 600000, "Petroleum");
		vAnsatt2.leggTilUndervisningemne(pet100);
		personer.add(vAnsatt2);
				
		//Teknisk ansatt
		TekniskAnsatt tAnsatt1 = new TekniskAnsatt("Ida", "Eriksen", 1980, 5, "IT-hjelp",
				350000);
		personer.add(tAnsatt1);
		tAnsatt1.setAnsvarsrom(auditorium1);
				
		TekniskAnsatt tAnsatt2 = new TekniskAnsatt("Karl", "Karlsen", 1975, 6,"Renholdsarbeider",
				300000);
		personer.add(tAnsatt2);
		tAnsatt2.setAnsvarsrom(grupperom1);
		
		skrivUtPersoner();
		
	}
	public static void skrivUtPersoner(){
		for(Person person: personer){
			System.out.print(person.toString() + "\n");
		}
	}

}
