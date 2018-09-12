package arving;

public class Ansatt extends Person {
	private int ansattNummer;
	private String stilling;
	private int arslonn;

	public Ansatt(String fornavn, String etternavn, int fodselsaar, int ansattNummer, String stilling, int arslonn) {
		super(fornavn, etternavn, fodselsaar);
		this.ansattNummer = ansattNummer;
		this.stilling = stilling;
		this.arslonn = arslonn;
	}

	@Override
	public String toString() {
		return "Ansatt [ansattNummer=" + ansattNummer + ", stilling=" + stilling + ", arslonn=" + arslonn
				+ ", getStilling()=" + getStilling() + ", getArslonn()=" + getArslonn() + ", getAnsattNummer()="
				+ getAnsattNummer() + ", getID()=" + getID() + ", getFodselsaar()=" + getFodselsaar()
				+ ", getFornavn()=" + getFornavn() + ", getEtternavn()=" + getEtternavn() + "]";
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getArslonn() {
		return arslonn;
	}

	public void setArslonn(int arslonn) {
		this.arslonn = arslonn;
	}

	public int getAnsattNummer() {
		return ansattNummer;
	}
}
