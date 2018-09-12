package veispill;

public class Hinder extends AbstraktRute {

	public Hinder(int posisjon) {
		super(posisjon);
	}

	@Override
	public void flyttHit(Spiller spilleren) {
		System.out.println("\nHinder: Spilleren blir stående på rute " + spilleren.getPosisjon());

	}

}
