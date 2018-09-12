package ruter;

import application.Spiller;
import javafx.scene.Node;

public abstract class LabyrintRute {
	int xKoordinat;
	int yKoordinat;
	public static final int RUTESTR = 40;

	public LabyrintRute(int xKoordinat, int yKoordinat) {
		this.xKoordinat = xKoordinat;
		this.yKoordinat = yKoordinat;
	}
	
	public abstract void flyttTilRute(Spiller spilleren);

	public abstract Node getUtseende();
	
	public abstract void settOppdaget(boolean oppdaget);

}
