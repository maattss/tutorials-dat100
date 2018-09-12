package arving;

import java.util.ArrayList;

public class Student extends Person {

	private String studieprogram;
	private int arskurs;
	private ArrayList <Emne> emner;

	public Student(String fornavn, String etternavn, int fodselsaar, String studieprogram, int arskurs) {
		super(fornavn, etternavn, fodselsaar);
		this.studieprogram = studieprogram;
		this.arskurs = arskurs;
		emner = new ArrayList<Emne>(); 
	}

	public String getStudieprogram() {
		return studieprogram;
	}

	public void setStudieprogram(String studieprogram) {
		this.studieprogram = studieprogram;
	}

	public int getArskurs() {
		return arskurs;
	}

	public void setArskurs(int arskurs) {
		this.arskurs = arskurs;
	}

	public ArrayList<Emne> getEmner() {
		return emner;
	}

	public void leggTilEmne(Emne emne) {
		emner.add(emne);
	}
	
	@Override
	public String toString() {
		return "Student [studieprogram=" + studieprogram + ", arskurs=" + arskurs + ", emner=" + emner
				+ ", getStudieprogram()=" + getStudieprogram() + ", getArskurs()=" + getArskurs() + ", getEmner()="
				+ getEmner() + ", getID()=" + getID() + ", getFodselsaar()=" + getFodselsaar() + ", getFornavn()="
				+ getFornavn() + ", getEtternavn()=" + getEtternavn() + "]";
	}
}
