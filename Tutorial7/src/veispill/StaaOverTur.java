package veispill;

public class StaaOverTur extends Hinder {

	public StaaOverTur(int posisjon) {
		super(posisjon);
	}
	@Override
	public void flyttHit(Spiller spilleren){
		System.out.println("Stå over tur og ");
		super.flyttHit(spilleren);
		spilleren.setStaaOverTur(true);
	}

}
