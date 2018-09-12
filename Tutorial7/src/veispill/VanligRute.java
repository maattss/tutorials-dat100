package veispill;

public class VanligRute extends AbstraktRute {

	public VanligRute(int posisjon) {
		super(posisjon);
	}

	@Override
	public void flyttHit(Spiller spilleren) {
		spilleren.setPosisjon(getPosisjon());
		System.out.println("\nVanlig rute: " + spilleren.getNavn() + " flytter til rute " + spilleren.getPosisjon());
	}

}
