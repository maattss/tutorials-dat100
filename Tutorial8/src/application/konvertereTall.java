package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class konvertereTall {
	private static int tekstfeltTall;
	
	public static void nyttInfoVindu(){
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("Informasjon");
		info.setContentText("Du tastet inn noe ugyldig. Tallet må "
				+ "være ett heltall mellom 1 og 1000.");
		info.setHeaderText("Feil inntasting");
		info.showAndWait();
	}
	
	public static int konverterTilTall(String tekstfeltstreng){
		try {
			tekstfeltTall = Integer.parseInt(tekstfeltstreng);
			if(tekstfeltTall < 1 || tekstfeltTall > 1000){
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			nyttInfoVindu();
		}
		return tekstfeltTall;
	}
}
