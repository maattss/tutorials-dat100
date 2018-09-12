package arving;

public class TekniskAnsatt extends Ansatt {
	private Rom ansvarsrom;

	public TekniskAnsatt(String fornavn, String etternavn, int fodselsaar, int ansattNummer, String stilling,
			int arslonn) {
		super(fornavn, etternavn, fodselsaar, ansattNummer, stilling, arslonn);

	}

	public Rom getAnsvarsrom() {
		return ansvarsrom;
	}

	public void setAnsvarsrom(Rom ansvarsrom) {
		this.ansvarsrom = ansvarsrom;
	}

	@Override
	public String toString() {
		return "TekniskAnsatt [ansvarsrom=" + ansvarsrom + ", getAnsvarsrom()=" + getAnsvarsrom() + ", getStilling()="
				+ getStilling() + ", getArslonn()=" + getArslonn() + ", getAnsattNummer()=" + getAnsattNummer()
				+ ", getID()=" + getID() + ", getFodselsaar()=" + getFodselsaar() + ", getFornavn()=" + getFornavn()
				+ ", getEtternavn()=" + getEtternavn() + "]";
	}

}
