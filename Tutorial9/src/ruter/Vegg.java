package ruter;

import application.Spiller;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vegg extends LabyrintRute {
	private Rectangle rektangel;

	public Vegg(int xKoordinat, int yKoordinat) {
		super(xKoordinat, yKoordinat);
		rektangel = new Rectangle(RUTESTR, RUTESTR, Color.GAINSBORO);
	}

	@Override
	public void flyttTilRute(Spiller spilleren) {
	}

	@Override
	public Node getUtseende() {
		return rektangel;
	}

	@Override
	public void settOppdaget(boolean oppdaget) {
		if (oppdaget == true) {
			rektangel.setFill(Color.BLUE);
		} else rektangel.setFill(Color.GAINSBORO);	
	}
}

