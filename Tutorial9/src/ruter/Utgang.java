package ruter;

import application.Main;
import application.Spiller;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Utgang extends LabyrintRute {
	private Rectangle rektangel;

	public Utgang(int xKoordinat, int yKoordinat) {
		super(xKoordinat, yKoordinat);
		rektangel = new Rectangle(RUTESTR, RUTESTR, Color.GAINSBORO);
	}

	@Override
	public void flyttTilRute(Spiller spilleren) {
		Main.leggTilantallflytt();
		Alert vunnet = new Alert(AlertType.INFORMATION);
		vunnet.setTitle("Vunnet");
		vunnet.setHeaderText("Gratulerer! Antall flytt: " + Main.getAntallflytt());
		vunnet.setContentText("Trykk OK for å avslutte");
		vunnet.showAndWait();
		System.exit(0);
	}

	@Override
	public Node getUtseende() {
		return rektangel;
	}

	@Override
	public void settOppdaget(boolean oppdaget) {
		if(oppdaget == true){
			rektangel.setFill(Color.RED);
		}else rektangel.setFill(Color.GAINSBORO);
	}

}
