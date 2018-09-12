package arving;

import java.util.ArrayList;

public class VitenskapeligAnsatt extends Ansatt {
	private String fagfelt;
	private ArrayList <Emne> undervisningemner;

	public VitenskapeligAnsatt(String fornavn, String etternavn, int fodselsaar, int ansattNummer, String stilling,
			int arslonn, String fagfelt) {
		super(fornavn, etternavn, fodselsaar, ansattNummer, stilling, arslonn);
		this.fagfelt = fagfelt;
		undervisningemner = new ArrayList<Emne>();
	}

	public String getFagfelt() {
		return fagfelt;
	}

	public void setFagfelt(String fagfelt) {
		this.fagfelt = fagfelt;
	}

	public ArrayList<Emne> getUndervisningEmner() {
		return undervisningemner;
	}

	public void leggTilUndervisningemne(Emne undervisningemne) {
		undervisningemner.add(undervisningemne);
	}

	@Override
	public String toString() {
		return "VitenskapeligAnsatt [fagfelt=" + fagfelt + ", undervisningemner=" + undervisningemner
				+ ", getFagfelt()=" + getFagfelt() + ", getUndervisningEmner()=" + getUndervisningEmner()
				+ ", getStilling()=" + getStilling() + ", getArslonn()=" + getArslonn() + ", getAnsattNummer()="
				+ getAnsattNummer() + ", getID()=" + getID() + ", getFodselsaar()=" + getFodselsaar()
				+ ", getFornavn()=" + getFornavn() + ", getEtternavn()=" + getEtternavn() + "]";
	}

}
