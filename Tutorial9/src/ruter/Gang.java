package ruter;

import application.Main;
import application.Spiller;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Gang extends LabyrintRute {
	private Rectangle rektangel;

	public Gang(int xKoordinat, int yKoordinat) {
		super(xKoordinat, yKoordinat);
		rektangel = new Rectangle(RUTESTR, RUTESTR, Color.GAINSBORO);
	}

	@Override
	public void flyttTilRute(Spiller spilleren) {
		spilleren.setxKoordinat(this.xKoordinat);
		spilleren.setyKoordinat(this.yKoordinat);
		Main.leggTilantallflytt();
	}

	@Override
	public Node getUtseende() {
		return rektangel;
	}

	@Override
	public void settOppdaget(boolean oppdaget) {
		if (oppdaget == true){
			rektangel.setFill(Color.BLACK);
		}else rektangel.setFill(Color.GAINSBORO);
		
	}

}
