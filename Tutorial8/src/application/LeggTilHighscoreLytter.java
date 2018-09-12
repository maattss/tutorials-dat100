package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LeggTilHighscoreLytter implements EventHandler<ActionEvent> {
	private SpillSpillet spillet;
	private Stage forrigeVindu;

	public LeggTilHighscoreLytter(SpillSpillet spillet, Stage forrigeVindu) {
		this.spillet = spillet;
		this.forrigeVindu = forrigeVindu;
	}

	@Override
	public void handle(ActionEvent event) {
		Stage vindu = new Stage();
		BorderPane layout = new BorderPane();
		Label navnLabel = new Label("Navn:");
		TextField navnTekstfelt = new TextField();
		HBox navnBoks = new HBox();
		navnBoks.getChildren().addAll(navnLabel, navnTekstfelt);
		navnBoks.setPadding(new Insets(10,10,10,10));
		navnBoks.setSpacing(10);
		navnBoks.setAlignment(Pos.CENTER);
		layout.setTop(navnBoks);
		
		Button leggTil = new Button ("Legg til");
		HBox leggTilBoks = new HBox();
		leggTilBoks.getChildren().add(leggTil);
		leggTilBoks.setPadding(new Insets(10,10,10,10));
		leggTilBoks.setAlignment(Pos.CENTER);
		layout.setBottom(leggTilBoks);
		leggTil.setOnAction(e -> {
			HighscoreSpiller spiller = new HighscoreSpiller
					(navnTekstfelt.getText(), spillet.getOmgang());
			spillet.leggTilHighscore(spiller);
			spillet.setHighscoreVerdi(spiller.getHighscore());
			vindu.close();
			forrigeVindu.close();
		});
		
		Scene nyScene = new Scene(layout);
		vindu.initOwner(forrigeVindu);
		vindu.initModality(Modality.APPLICATION_MODAL);
		vindu.setScene(nyScene);
		vindu.sizeToScene();
		vindu.setTitle("Legg til highscore");
		vindu.showAndWait();
		
	}

}
