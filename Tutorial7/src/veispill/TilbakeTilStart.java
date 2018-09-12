package veispill;

public class TilbakeTilStart extends AbstraktRute {

	public TilbakeTilStart(int posisjon) {
		super(posisjon);
	}

	@Override
	public void flyttHit(Spiller spilleren) {
		spilleren.setPosisjon(0);
		System.out.println("\nTilbake til start: " + spilleren.getNavn()+ " må flyttet tilbake til start!");
	}
}
