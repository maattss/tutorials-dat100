package veispill;

public abstract class AbstraktRute implements Rute {
	private int posisjon;
	
	public AbstraktRute(int posisjon) {
		this.posisjon = posisjon;
	}
	public int getPosisjon() {
		return posisjon;
	}
	
	public abstract void flyttHit(Spiller spilleren);
}
