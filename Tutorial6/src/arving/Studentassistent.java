package arving;

import java.util.ArrayList;

public class Studentassistent extends Student {
	private int ansattnummer;
	private int timelonn;
	private int antallTimer;
	ArrayList<Emne> studassEmner;

	public Studentassistent(String fornavn, String etternavn, int fodselsaar,
			String studieprogram, int arskurs, int ansattnummer) {
		super(fornavn, etternavn, fodselsaar, studieprogram, arskurs);
		this.ansattnummer = ansattnummer;
		timelonn = 150;
		antallTimer = 0;
		studassEmner = new ArrayList<Emne>();
	}

	public int getAnsattnummer() {
		return ansattnummer;
	}

	public void setAnsattnummer(int ansattnummer) {
		this.ansattnummer = ansattnummer;
	}

	public int getTimelonn() {
		return timelonn;
	}

	public void setTimelonn(int timelonn) {
		this.timelonn = timelonn;
	}

	public int getAntallTimer() {
		return antallTimer;
	}

	public void setAntallTimer(int antallTimer) {
		this.antallTimer = antallTimer;
	}

	public ArrayList<Emne> getStudassEmner() {
		return studassEmner;
	}

	public void leggTilStudassEmne(Emne emne) {
		studassEmner.add(emne);
	}

}
