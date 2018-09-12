package veispill;

import java.util.Scanner;

public class EkstraKast extends AbstraktRute {

	public EkstraKast(int posisjon) {
		super(posisjon);
	}

	@Override
	public void flyttHit(Spiller spilleren) {
		spilleren.setPosisjon(getPosisjon());
		System.out.println("\nEkstra kast: " + spilleren.getNavn() +
				" flytter til rute " + spilleren.getPosisjon() +
				". Trykk enter for å fortsett.");
		Scanner inn = new Scanner(System.in);
		inn.nextLine();
		SelveSpillet.kast(spilleren);
	
	}

}
